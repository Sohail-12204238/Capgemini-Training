package com.example.demo.service;


import org.springframework.data.domain.Page;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;

public interface EmployeeService {
	EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);
	
	EmployeeResponseDTO getEmployeeById(Long id);
	
	Page<EmployeeResponseDTO> getAllEmployees(int page,int size,String sortBy);
	
	EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO dto);
	
	void deleteEmployee(Long id);
	
	Page<EmployeeResponseDTO> findByDepartment(String name,int page,int size);
	
	Page<EmployeeResponseDTO> findBySalaryRange(double minSalary,double maxSalary,int page,int size);
}
