package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RestaurantRequestDTO;
import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping
	public RestaurantResponseDTO createRestaurant(@RequestBody RestaurantRequestDTO dto) {
		return restaurantService.createRestaurant(dto);
	}
	
	@GetMapping
	public List<RestaurantResponseDTO> getAllRestaurants(){
		return restaurantService.getAllRestaurants();
	}
	
	@GetMapping("/{id}")
	public RestaurantResponseDTO getRestaurantById(@PathVariable Long id) {
		return restaurantService.getRestaurantById(id);
	}
}
