package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Customer;
import com.example.demo.model.Policy;
import com.example.demo.model.Status;

@Component
public class PolicyMapper {
	public Policy toEntity(PolicyRequestDTO dto) {
	    Policy policy = new Policy();
	    Customer customer = new Customer();

	    policy.setPolicyNumber(dto.getPolicyNumber());
	    policy.setPolicyType(dto.getPolicyType());
	    policy.setPremiumAmount(dto.getPremiumAmount());
	    policy.setCoverageAmount(dto.getCoverageAmount());
	    policy.setStatus(Status.ACTIVE);
	    policy.setStartDate(dto.getStartDate());
	    policy.setEndDate(dto.getEndDate());

	    customer.setId(dto.getCustomerId());
	    policy.setCustomer(customer);

	    return policy;
	}
	
	public PolicyResponseDTO toDTO(Policy policy) {
		CustomerResponseDTO customerDTO = new CustomerResponseDTO(
				policy.getCustomer().getId(),
				policy.getCustomer().getName(),
				policy.getCustomer().getEmail(),
				policy.getCustomer().getPhoneNumber(),
				policy.getCustomer().getAddress());
		
		PolicyResponseDTO dto = new PolicyResponseDTO();
		dto.setId(policy.getId());
		dto.setPolicyNumber(policy.getPolicyNumber());
		dto.setPolicyType(policy.getPolicyType());
		dto.setPremiumAmount(policy.getPremiumAmount());
		dto.setCoverageAmount(policy.getCoverageAmount());
		dto.setStartDate(policy.getStartDate());
		dto.setEndDate(policy.getEndDate());
		dto.setStatus(policy.getStatus());
		dto.setCustomer(customerDTO);
		return dto;
	}
}
