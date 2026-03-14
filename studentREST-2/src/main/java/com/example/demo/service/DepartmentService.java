package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.DepartmentRequestDTO;
import com.example.demo.dto.DepartmentResponseDTO;

public interface DepartmentService {
	DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto);
	
	Page<DepartmentResponseDTO> getAllDepartments(int page,int size);
	
	DepartmentResponseDTO getDepartmentById(Long id);
}
