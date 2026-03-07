package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Customer;

@Component
public class CustomerMapper {
	public Customer toEntity(CustomerRequestDTO dto) {
		Customer customer = new Customer();
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		customer.setPhoneNumber(dto.getPhoneNumber());
		customer.setAddress(dto.getAddress());
		return customer;
	}
	
	public CustomerResponseDTO toDTO(Customer customer) {
		CustomerResponseDTO dto = new CustomerResponseDTO();
		dto.setId(customer.getId());
		dto.setName(customer.getName());
		dto.setEmail(customer.getEmail());
		dto.setPhoneNumber(customer.getPhoneNumber());
		dto.setAddress(customer.getAddress());
		return dto;
	}
}
