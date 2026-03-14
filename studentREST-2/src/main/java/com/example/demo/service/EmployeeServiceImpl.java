package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeMapper;
import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
		
		Department fetchDepartment = departmentRepository.findById(dto.getDepartment_id()).orElseThrow(
				() -> new DepartmentNotFoundException("Department Not Found"));
		
		Employee employee = employeeMapper.toEntity(dto);
		employee.setDepartment(fetchDepartment);
		return employeeMapper.toDTO(employeeRepository.save(employee));
	}
	
	@Override
	public EmployeeResponseDTO getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new EmployeeNotFoundException("Employee Not Found"));
		return employeeMapper.toDTO(employee);
	}
	
	@Override
	public Page<EmployeeResponseDTO> getAllEmployees(int page,int size,String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		Page<Employee> employees = employeeRepository.findAll(pageable); 
		return employees.map(employeeMapper::toDTO);
	}
	
	@Override
	public EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO dto) {
		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new EmployeeNotFoundException("Employee Not Found"));
		
		Department department = departmentRepository.findById(dto.getDepartment_id()).orElseThrow(
				() -> new DepartmentNotFoundException("Department Not Found"));
		
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		employee.setSalary(dto.getSalary());
		employee.setDepartment(department);
		
		employeeRepository.save(employee);
		
		return employeeMapper.toDTO(employee);
	}
	
	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new EmployeeNotFoundException("Employee Not Found Exception"));
		employeeRepository.delete(employee);	
	}
	
	@Override
	public Page<EmployeeResponseDTO> findByDepartment(String name,int page,int size){
		Pageable pageable = PageRequest.of(page,size);
		Page<Employee> employees = employeeRepository.findByDepartment_Name(name, pageable);
		return employees.map(employeeMapper::toDTO);
	}
	
	@Override
	public Page<EmployeeResponseDTO> findBySalaryRange(double minSalary,double maxSalary,int page,int size){
		Pageable pageable = PageRequest.of(page, size);
		Page<Employee> employees = employeeRepository.findBySalaryBetween(minSalary, maxSalary, pageable);
		return employees.map(employeeMapper::toDTO);
	}
}
