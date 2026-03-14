package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Movie;

@Component
public class MovieMapper {
	public Movie toEntity(MovieRequestDTO dto) {
		return new Movie(dto.getName(),dto.getLanguage(),dto.getPrice());
	}
	
	public MovieResponseDTO toDTO(Movie movie) {
		return new MovieResponseDTO(movie.getId(),movie.getName(),movie.getLanguage(),movie.getPrice());
	}
}
