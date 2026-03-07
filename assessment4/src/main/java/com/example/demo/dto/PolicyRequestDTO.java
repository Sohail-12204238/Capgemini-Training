package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.PolicyType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyRequestDTO {
	
	@NotNull(message = "Policy Number is Required")
	private Long policyNumber;
	
	@NotNull(message = "Policy Type is Required")
	private PolicyType policyType;
	
	@Positive(message = "Premium Amount is Required")
	private double premiumAmount;
	
	@Positive(message = "Coverage Amount is Required")
	private double coverageAmount;
	
	@NotNull(message = "Start Date is Required")
	private LocalDate startDate;
	
	@NotNull(message = "End Date is Required")
	private LocalDate endDate;
	
	@NotNull(message = "Customer ID is Required")
	private Long customerId;
}
