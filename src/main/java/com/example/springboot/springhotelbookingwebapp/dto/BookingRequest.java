package com.example.springboot.springhotelbookingwebapp.dto;

import com.example.springboot.springhotelbookingwebapp.entity.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingRequest {
	
	private Person person;

}
