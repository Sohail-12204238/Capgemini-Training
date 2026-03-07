package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Policy;
import com.example.demo.model.PolicyType;

public interface PolicyRepository extends JpaRepository<Policy, Long>{
		
	List<Policy> findByPolicyType(PolicyType policyType);
	
	List<Policy> findByCustomerId(Long id);
	
	Page<Policy> findByPremiumAmountBetween(double minAmount,double maxAmount,Pageable pageable);
}
