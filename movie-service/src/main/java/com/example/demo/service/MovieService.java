package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MovieMapper;
import com.example.demo.dto.MovieRequestDTO;
import com.example.demo.dto.MovieResponseDTO;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {
	private MovieRepository movieRepository;
	private MovieMapper mapper;
	public MovieService(MovieRepository movieRepository, MovieMapper mapper) {
		this.movieRepository = movieRepository;
		this.mapper = mapper;
	}
	
	public MovieResponseDTO createMovie(MovieRequestDTO dto) {
		return mapper.toDTO(movieRepository.save(mapper.toEntity(dto)));
	}
	
	public List<MovieResponseDTO> getAllMovies(){
		return movieRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
	}
	
	public MovieResponseDTO getMovieById(Long id) {
		return mapper.toDTO(movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie Not Found")));
	}
}
