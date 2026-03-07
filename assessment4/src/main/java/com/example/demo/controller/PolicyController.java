package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.PolicyMapper;
import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.model.Policy;
import com.example.demo.model.PolicyType;
import com.example.demo.service.PolicyServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/policies")
public class PolicyController {

	
	@Autowired
	private PolicyServiceImpl policyServiceImpl;

	@Autowired
	private PolicyMapper policyMapper;
	

	@PostMapping
	public ResponseEntity<PolicyResponseDTO> createPolicy(@Valid @RequestBody PolicyRequestDTO dto){
		Policy policy = policyMapper.toEntity(dto);
		return ResponseEntity.ok(policyServiceImpl.createPolicy(policy));
	}
	
	@GetMapping("/{id:\\d+}")
	public ResponseEntity<PolicyResponseDTO> getPolicyById(@PathVariable Long id){
		return ResponseEntity.ok(policyServiceImpl.getPolicyById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PolicyResponseDTO> updatePolicyById(@PathVariable Long id, @RequestBody PolicyRequestDTO dto){
		return ResponseEntity.ok(policyServiceImpl.updatePolicyById(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> cancelPolicy(@PathVariable Long id) {
		policyServiceImpl.cancelPolicy(id);
		return ResponseEntity.ok("Policy deleted successfully!");
	}
	
	@GetMapping
	public ResponseEntity<List<PolicyResponseDTO>> getPolicies(){
		List<PolicyResponseDTO> policies = policyServiceImpl.getPolicies();
		return ResponseEntity.ok(policies);
	}
	
	@GetMapping("/type/{policyType}")
	public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByType(@PathVariable PolicyType policyType){
		List<PolicyResponseDTO> policiesList = policyServiceImpl.getPoliciesByType(policyType);
		return ResponseEntity.ok(policiesList);
	}
	
	@GetMapping("/premium")
	public ResponseEntity<Page<PolicyResponseDTO>> getPoliciesByPremiumRange(
			@RequestParam double minAmount,
			@RequestParam double maxAmount,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "id") String sortBy){
		Page<PolicyResponseDTO> policiesList = policyServiceImpl.getPoliciesByPremiumRange(minAmount, maxAmount, page, size, sortBy);
		return ResponseEntity.ok(policiesList);
	}
}
