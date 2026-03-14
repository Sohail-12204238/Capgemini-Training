package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {
	
	@NotBlank(message = "First Name is required")
	private String firstName;
	
	@NotBlank(message = "Last Name is required")
	private String lastName;
	
	@Email(message = "Invalid Email Format")
	private String email;
	
	@Positive(message = "Salary must be positive")
	private double salary;
	
	@NotNull(message = "Department ID is required")
	private Long department_id;
	
}
