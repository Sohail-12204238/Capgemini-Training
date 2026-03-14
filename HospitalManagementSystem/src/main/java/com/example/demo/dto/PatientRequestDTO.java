package com.example.demo.dto;

import lombok.Data;

@Data
public class PatientRequestDTO {
	private Long id;	
	private String name;
	private Integer age;
	private Long contactNumber;
	private String medicalHistory;
	private Long doctorId;
}
