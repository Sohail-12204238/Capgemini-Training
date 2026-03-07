package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.model.Policy;
import com.example.demo.model.PolicyType;

public interface PolicyService {
	PolicyResponseDTO createPolicy(Policy policy);
	PolicyResponseDTO getPolicyById(Long id);
	PolicyResponseDTO updatePolicyById(Long id,PolicyRequestDTO dto);
	void cancelPolicy(Long id);
	List<PolicyResponseDTO> getPoliciesByType(PolicyType policyType);
	Page<PolicyResponseDTO> getPoliciesByPremiumRange(double minAmount,double maxAmount,int page,int size,String sortBy);
	List<PolicyResponseDTO> getPolicies();
}
