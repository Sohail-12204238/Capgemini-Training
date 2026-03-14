package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.RestaurantResponseDTO;

@FeignClient(name = "RESTAURANT-SERVICE")
public interface RestaurantClient {
	@GetMapping("/{id}")
	RestaurantResponseDTO getRestaurantById(@PathVariable Long id);

}
