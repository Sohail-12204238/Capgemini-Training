package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@Controller
public class MovieController {
	public MovieService movieService;
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/addMovie")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		return "addMovie";
	}
	
	@GetMapping("/view")
	public String viewMovie(Model model) {
		List<Movie> movies = movieService.getMovies();
		model.addAttribute("movies",movies);
		return "view";
	}
	
	@GetMapping("/save")
	public String saveMovie(Movie movie) {
		movieService.saveMovies(movie);
		return "redirect:/view";
	}
	
	@GetMapping("/update/{id}")
	public String updateMovie(@PathVariable Long id,Model model) {
		Movie movie = movieService.getMovieById(id);
		model.addAttribute("movie",movie);
		return "addMovie";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieService.deleteMovieById(id);
		return "redirect:/view";
	}
	
}
