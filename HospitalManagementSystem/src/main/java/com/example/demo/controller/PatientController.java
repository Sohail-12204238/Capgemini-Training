package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.PatientRequestDTO;
import com.example.demo.dto.PatientResponseDTO;
import com.example.demo.service.PatientService;

@Controller
@RequestMapping("/api/patients")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ResponseEntity<List<PatientResponseDTO>> getAllPatients(){
		return ResponseEntity.ok(patientService.getAllPatients());
	}
	
	@PostMapping
	public ResponseEntity<PatientResponseDTO> createPatient(PatientRequestDTO dto){
		return ResponseEntity.ok(patientService.createPatient(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable Long id){
		return ResponseEntity.ok(patientService.getPatientById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PatientResponseDTO> updatePatientById(@PathVariable Long id,PatientRequestDTO dto){
		return ResponseEntity.ok(patientService.updatePatientById(id, dto));
	}
}
