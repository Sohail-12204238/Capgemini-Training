package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.service.EmployeeServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	public EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> addEmployee(@Valid @RequestBody EmployeeRequestDTO dto) {
		EmployeeResponseDTO employee = employeeServiceImpl.createEmployee(dto);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Page<EmployeeResponseDTO>> getAllEmployees(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue =  "id") String sortBy){
		Page<EmployeeResponseDTO> employees = employeeServiceImpl.getAllEmployees(page, size, sortBy);
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id){
		EmployeeResponseDTO employee = employeeServiceImpl.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployeeById(@PathVariable Long id,@Valid @RequestBody EmployeeRequestDTO dto){
		EmployeeResponseDTO employee = employeeServiceImpl.updateEmployeeById(id, dto);
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		employeeServiceImpl.deleteEmployee(id);
		return ResponseEntity.ok("Employee Deleted Successfully");
	}
	
	@GetMapping("/department")
	public ResponseEntity<Page<EmployeeResponseDTO>> findByDepartment(
			@RequestParam String department,
			@RequestParam int page,
			@RequestParam int size){
		Page<EmployeeResponseDTO> employees = employeeServiceImpl.findByDepartment(department, page, size);
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/salary")
	public ResponseEntity<Page<EmployeeResponseDTO>> findBySalaryRange(
			@RequestParam double minSalary,
			@RequestParam double maxSalary,
			@RequestParam int page,
			@RequestParam int size){
		Page<EmployeeResponseDTO> employees = employeeServiceImpl.findBySalaryRange(minSalary, maxSalary, page, size);
		return ResponseEntity.ok(employees);
	}
	
}
