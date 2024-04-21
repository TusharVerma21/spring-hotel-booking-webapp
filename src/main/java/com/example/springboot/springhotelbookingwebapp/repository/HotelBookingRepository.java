package com.example.springboot.springhotelbookingwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.springhotelbookingwebapp.entity.HotelBooking;

@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBooking, Integer>{
	
}
