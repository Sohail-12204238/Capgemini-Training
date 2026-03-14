package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MovieRequestDTO;
import com.example.demo.dto.MovieResponseDTO;
import com.example.demo.service.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	private final MovieService movieService;
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@PostMapping
	public ResponseEntity<MovieResponseDTO> createMovie(@Valid @RequestBody MovieRequestDTO dto){
		return ResponseEntity.ok(movieService.createMovie(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<MovieResponseDTO>> getAllMovies(){
		return ResponseEntity.ok(movieService.getAllMovies());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable Long id){
		return ResponseEntity.ok(movieService.getMovieById(id));
	}
}
