package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentRequestDTO;
import com.example.demo.dto.DepartmentResponseDTO;
import com.example.demo.service.DepartmentServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	public DepartmentServiceImpl departmentServiceImpl;
	
	@PostMapping
	public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO dto){
		return new ResponseEntity<>(departmentServiceImpl.createDepartment(dto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Page<DepartmentResponseDTO>> getAllDepartments(
			@RequestParam int page,
			@RequestParam int size){
		Page<DepartmentResponseDTO> departments = departmentServiceImpl.getAllDepartments(page, size);
		return ResponseEntity.ok(departments);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Long id){
		DepartmentResponseDTO department = departmentServiceImpl.getDepartmentById(id);
		return ResponseEntity.ok(department);
	}
}
