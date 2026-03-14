package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private double salary;
	private DepartmentResponseDTO department;
}
