package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;

@Component
public class EmployeeMapper {
	public Employee toEntity(EmployeeRequestDTO dto) {
		Employee employee = new Employee();
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		employee.setSalary(dto.getSalary());
		return employee;
	}
	
	public EmployeeResponseDTO toDTO(Employee employee) {
		DepartmentResponseDTO deptDto = new DepartmentResponseDTO(
				employee.getDepartment().getId(),
				employee.getDepartment().getName(),
				employee.getDepartment().getLocation());
		
		EmployeeResponseDTO dto = new EmployeeResponseDTO();
		dto.setId(employee.getId());
		dto.setFirstName(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		dto.setEmail(employee.getEmail());
		dto.setSalary(employee.getSalary());
		dto.setDepartment(deptDto);
		return dto;
	}
}
