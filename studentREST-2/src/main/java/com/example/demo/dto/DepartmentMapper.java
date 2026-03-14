package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Department;

@Component
public class DepartmentMapper {
	public Department toEntity(DepartmentRequestDTO dto) {
		Department department = new Department();
		department.setName(dto.getName());
		department.setLocation(dto.getLocation());
		return department;
	}
	
	public DepartmentResponseDTO toDTO(Department department) {
		DepartmentResponseDTO dto = new DepartmentResponseDTO();
		dto.setId(department.getId());
		dto.setName(department.getName());
		dto.setLocation(department.getLocation());
		return dto;
	}
}
