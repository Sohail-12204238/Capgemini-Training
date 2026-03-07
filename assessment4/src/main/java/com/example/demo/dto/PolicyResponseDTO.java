package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.PolicyType;
import com.example.demo.model.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyResponseDTO {
	private Long id;
	private Long policyNumber;
	private PolicyType policyType;
	private double premiumAmount;
	private double coverageAmount;
	private LocalDate startDate;
	private LocalDate endDate;
	private Status status;
	private CustomerResponseDTO customer;
}
