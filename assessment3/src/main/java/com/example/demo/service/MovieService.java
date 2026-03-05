package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {
	public MovieRepository movieRepository;
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> getMovies(){
		return movieRepository.findAll();
	}
	
	public void saveMovies(Movie movie) {
		movieRepository.save(movie);
	}
	
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).orElse(null);
	}
	
	public void deleteMovieById(Long id) {
		movieRepository.deleteById(id);
	}
}
