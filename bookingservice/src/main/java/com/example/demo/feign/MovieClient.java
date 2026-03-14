package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.MovieResponseDTO;

@FeignClient(name = "MOVIE-SERVICE")
public interface MovieClient {
	@GetMapping("/movies/{id}")
	MovieResponseDTO getMovieById(@PathVariable Long id);
}
