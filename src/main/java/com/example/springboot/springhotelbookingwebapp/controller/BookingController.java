package com.example.springboot.springhotelbookingwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.springhotelbookingwebapp.entity.HotelBooking;
import com.example.springboot.springhotelbookingwebapp.entity.Person;
import com.example.springboot.springhotelbookingwebapp.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@PostMapping("/bookHotel")
	public String bookHotel(@RequestBody Person request) {
		return service.bookHotel(request);
	}
	
	@PutMapping("/addHotelBooking/{personId}")
	public Person addHotelBooking(@PathVariable int personId, @RequestBody HotelBooking request) {
		return service.addHotelBooking(personId, request);
	}
	
	@GetMapping("/persons")
	public List<Person> getPersons(){
		return service.getPersons();
	}
	
	@GetMapping("/persons/{personId}")
	public Person getPerson(@PathVariable int personId){
		return service.getPerson(personId);
	}
	
	@GetMapping("/hotelsBookings")
	public List<HotelBooking> getHotelsBookings(){
		return service.getHotelsBookings();
	}
	
	@GetMapping("/hotelsBookings/{personId}")
	public List<HotelBooking> getHotelBookingsByPerson(@PathVariable int personId){
		return service.getHotelBookingsByPerson(personId);
	}
	
	@DeleteMapping("/cancelHotelBooking/{bookingId}")
	public String cancelHotelBooking(@PathVariable int bookingId) {
		
		return service.cancelHotelBooking(bookingId);
	}
	

}
