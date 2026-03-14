package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BookingMapper;
import com.example.demo.dto.BookingRequestDTO;
import com.example.demo.dto.BookingResponseDTO;
import com.example.demo.dto.MovieResponseDTO;
import com.example.demo.feign.MovieClient;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class BookingService {
	
	private final BookingRepository bookingRepository;
	private final BookingMapper bookingMapper;
	private final MovieClient movieClient;
	public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper, MovieClient movieClient) {
		this.bookingRepository = bookingRepository;
		this.bookingMapper = bookingMapper;
		this.movieClient = movieClient;
	}

	@CircuitBreaker(name = "movieService", fallbackMethod = "movieFallBack")
	public BookingResponseDTO createBooking(BookingRequestDTO dto) {
		MovieResponseDTO movieResponseDTO = movieClient.getMovieById(dto.getMovieId());
		Double totalAmount = movieResponseDTO.getPrice() * dto.getTickets();
		Booking booking = new Booking(dto.getMovieId(),dto.getTickets(),totalAmount);
		return bookingMapper.toDTO(bookingRepository.save(booking));	
	}
	
	public BookingResponseDTO movieFallBack(BookingRequestDTO dto, Exception e) {
		Booking booking = new Booking(
				dto.getMovieId(),
				dto.getTickets(),
				0.0);
		Booking saved = bookingRepository.save(booking);
		return new BookingResponseDTO(booking.getId(),booking.getMovieId(),booking.getTickets(),0.0);
	}

	public List<BookingResponseDTO> getAllBooking(){
		return bookingRepository.findAll().stream().map(bookingMapper::toDTO).collect(Collectors.toList());
	}
}
