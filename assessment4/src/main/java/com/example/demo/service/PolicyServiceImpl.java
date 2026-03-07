package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PolicyMapper;
import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.exception.PolicyNotFoundException;
import com.example.demo.model.Policy;
import com.example.demo.model.PolicyType;
import com.example.demo.model.Status;
import com.example.demo.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService{
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private PolicyMapper policyMapper;
	
	@Override
	public PolicyResponseDTO createPolicy(Policy policy) {
		return policyMapper.toDTO(policyRepository.save(policy));
	}

	@Override
	public PolicyResponseDTO getPolicyById(Long id) {
		Policy policy = policyRepository.findById(id).orElseThrow(() -> new PolicyNotFoundException("Policy Not Found"));
		return policyMapper.toDTO(policy);
	}

	@Override
	public PolicyResponseDTO updatePolicyById(Long id, PolicyRequestDTO dto) {
		Policy policy = policyRepository.findById(id).orElseThrow(() -> new PolicyNotFoundException("Policy Not Found"));
		policy.setPolicyNumber(dto.getPolicyNumber());
		policy.setPolicyType(dto.getPolicyType());
		policy.setPremiumAmount(dto.getPremiumAmount());
		policy.setCoverageAmount(dto.getCoverageAmount());
		policy.setStatus(Status.ACTIVE);
		policy.setStartDate(dto.getStartDate());
		policy.setEndDate(dto.getEndDate());
		
		return policyMapper.toDTO(policyRepository.save(policy));
	}

	@Override
	public void cancelPolicy(Long id) {
		Policy policy = policyRepository.findById(id)
	            .orElseThrow(() -> new PolicyNotFoundException("Policy Not Found"));

	    policy.setStatus(Status.CANCELLED);
	    policyRepository.save(policy);
	}

	@Override
	public List<PolicyResponseDTO> getPoliciesByType(PolicyType policyType) {
		return policyRepository.findByPolicyType(policyType).stream().map(policyMapper::toDTO).toList();
	}

	@Override
	public Page<PolicyResponseDTO> getPoliciesByPremiumRange(double minAmount, double maxAmount,int page,int size,String sortBy) {
		Pageable pageable = PageRequest.of(page,size,Sort.by(sortBy));
		Page<Policy> pages = policyRepository.findByPremiumAmountBetween(minAmount, maxAmount, pageable);
		return pages.map(policyMapper::toDTO);
	}
	
	@Override
	public List<PolicyResponseDTO> getPolicies(){
		return policyRepository.findAll().stream().map(policyMapper::toDTO).toList();
	}
}
