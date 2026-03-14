package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Restaurant;

@Component
public class RestaurantMapper {
	public Restaurant toEntity(RestaurantRequestDTO dto) {
		Restaurant restaurant = new Restaurant();
		restaurant.setName(dto.getName());
		restaurant.setAddress(dto.getAddress());
		return restaurant;
	}
	
	public RestaurantResponseDTO toDTO(Restaurant restaurant) {
		return new RestaurantResponseDTO(restaurant.getId(),restaurant.getName(),restaurant.getAddress());
	}
}
