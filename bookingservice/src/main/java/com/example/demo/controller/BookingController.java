package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingRequestDTO;
import com.example.demo.dto.BookingResponseDTO;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	private final BookingService bookingService;
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@GetMapping
	public ResponseEntity<List<BookingResponseDTO>> getAllBookings(){
		return ResponseEntity.ok(bookingService.getAllBooking());
	}
	
	@PostMapping
	public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO dto){
		return ResponseEntity.ok(bookingService.createBooking(dto));
	}
}