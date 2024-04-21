package com.example.springboot.springhotelbookingwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.springhotelbookingwebapp.entity.HotelBooking;
import com.example.springboot.springhotelbookingwebapp.entity.Person;
import com.example.springboot.springhotelbookingwebapp.repository.HotelBookingRepository;
import com.example.springboot.springhotelbookingwebapp.repository.PersonRepository;

@Service
public class BookingService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private HotelBookingRepository bookingRepository;
	
	public String bookHotel(Person request) {
		
		Person person = new Person();
		
		person.setEmail(request.getEmail());
		person.setGender(request.getGender());
		person.setName(request.getName());
		
		personRepository.save(person);
		
		List<HotelBooking> hotelBookingList = request.getHotelBookings();
		
		for (HotelBooking hotelBooking : hotelBookingList) {
			hotelBooking.setPerson(person);
		}
		
		bookingRepository.saveAll(hotelBookingList);
		
		StringBuilder result = new StringBuilder();
		
		String pronoun = (request.getGender().equalsIgnoreCase("male")) ? "His" : "Her";
		
		if(hotelBookingList.size() == 1) {
			HotelBooking hotelBooked = hotelBookingList.get(0);
			
			result.append( request.getName() + " has booked hotel " + hotelBooked.getHotelName() + " for " +
						hotelBooked.getNumPersons() + " persons "+ " with " + hotelBooked.getNumRooms() + 
						" rooms. " + pronoun + " arrival is scheduled for " + hotelBooked.getCheckInDate() +
						" with checkout on " + hotelBooked.getCheckOutDate());
		}
		else {
			
			result.append(request.getName() + " has booked the following hotels: ");
			
			for (HotelBooking hotelBooking : hotelBookingList) {
		
				result.append("\n " + hotelBooking.getHotelName() + " of " + hotelBooking.getCity() 
						+ " for " + hotelBooking.getNumPersons() + " guests with " + hotelBooking.getNumRooms() + 
						" rooms. " + pronoun + " arrival is scheduled for " + hotelBooking.getCheckInDate() +
						" with checkout on " + hotelBooking.getCheckOutDate());
				
			}
		}
		
		return result.toString();
		
	}
	
	public Person addHotelBooking(int personId, HotelBooking request) {
		Person guest = personRepository.findById(personId).get();
		request.setPerson(guest);
		
		bookingRepository.save(request);
		
		return getPerson(personId);
	}
	
	public List<Person> getPersons(){
		return personRepository.findAll();
	}
	
	public Person getPerson(int personId){
		return personRepository.findById(personId).get();
	}
	
	public List<HotelBooking> getHotelsBookings(){
		return bookingRepository.findAll();
	}
	
	public List<HotelBooking> getHotelBookingsByPerson(int personId){
		Person guest = personRepository.findById(personId).get();
		
		return guest.getHotelBookings();
	}
	
	public String cancelHotelBooking(int bookingId) {
		HotelBooking hotelBooking = bookingRepository.findById(bookingId).get();
		
		bookingRepository.deleteById(bookingId);
				
		String outputString = "Reservation for "+ hotelBooking.getHotelName() + " for dates " + 
								hotelBooking.getCheckInDate() + " and " + hotelBooking.getCheckOutDate()+
								" has cancelled";
		
		return outputString;
	}
	

}
