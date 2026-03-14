package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentMapper;
import com.example.demo.dto.DepartmentRequestDTO;
import com.example.demo.dto.DepartmentResponseDTO;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto) {
		Department department = departmentMapper.toEntity(dto);
		return departmentMapper.toDTO(departmentRepository.save(department));
	}
	
	@Override
	public Page<DepartmentResponseDTO> getAllDepartments(int page,int size){
		Pageable pageable = PageRequest.of(page, size);
		Page<Department> departments = departmentRepository.findAll(pageable);
		return departments.map(departmentMapper::toDTO);
	}
	
	@Override
	public DepartmentResponseDTO getDepartmentById(Long id) {
		Department department = departmentRepository.findById(id).orElseThrow(
				() -> new DepartmentNotFoundException("Department Not Found"));
		
		return departmentMapper.toDTO(department);
	}
}
