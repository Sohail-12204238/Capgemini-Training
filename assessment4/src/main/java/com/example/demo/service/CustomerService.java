package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CustomerResponseDTO;
import com.example.demo.model.Customer;

public interface CustomerService {
	CustomerResponseDTO createCustomer(Customer customer);
	List<CustomerResponseDTO> getAllCustomers();
	CustomerResponseDTO getCustomerById(Long id);
}
