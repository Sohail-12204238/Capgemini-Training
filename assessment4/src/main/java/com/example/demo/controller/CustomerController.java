package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerMapper;
import com.example.demo.dto.CustomerRequestDTO;
import com.example.demo.dto.CustomerResponseDTO;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO dto){
		Customer customer = customerMapper.toEntity(dto);
		return ResponseEntity.ok(customerService.createCustomer(customer));
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers(){
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long id){
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}
}
