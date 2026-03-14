package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long movieId;
	private Integer tickets;
	private Double totalAmount;
	public Booking(Long movieId, Integer tickets, Double totalAmount) {
		this.movieId = movieId;
		this.tickets = tickets;
		this.totalAmount = totalAmount;
	}
	public Booking(Long movieId, Integer tickets) {
		this.movieId = movieId;
		this.tickets = tickets;
	}
	
}
