package com.example.springboot.springhotelbookingwebapp.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@JsonIgnoreProperties(value = {"person"})
public class HotelBooking {
	
	@Id
	@GeneratedValue
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	private String hotelName;
	
	private String city;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate checkInDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate checkOutDate;
	
	private int numPersons;
	
	private int numRooms;
	
}
