package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerMapper;
import com.example.demo.dto.CustomerResponseDTO;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public CustomerResponseDTO createCustomer(Customer customer) {
		return customerMapper.toDTO(customerRepository.save(customer));
	}
	
	@Override
	public List<CustomerResponseDTO> getAllCustomers(){
		return customerRepository.findAll().stream().map(customerMapper::toDTO).toList();
	}
	
	@Override
	public CustomerResponseDTO getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
		return customerMapper.toDTO(customer);
	}
}
