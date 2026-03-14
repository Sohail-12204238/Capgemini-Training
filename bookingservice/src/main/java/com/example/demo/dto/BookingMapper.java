package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Booking;

@Component
public class BookingMapper {
	public Booking toEntity(BookingRequestDTO dto) {
		return new Booking(dto.getMovieId(), dto.getTickets());
	}
	
	public BookingResponseDTO toDTO(Booking booking) {
		return new BookingResponseDTO(booking.getId(),booking.getMovieId(),booking.getTickets(),booking.getTotalAmount());
	}
}
