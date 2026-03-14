package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RestaurantResponseDTO;
import com.example.demo.feign.RestaurantClient;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestaurantClient restaurantClient;
	
	public Order getRestaurantName(Order order) {
		RestaurantResponseDTO restaurant = restaurantClient.getRestaurantById(order.getId());
		order.setRestaurantAddress(restaurant.getAddress());
		return orderRepository.save(order);
	}
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
}
