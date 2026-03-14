package com.example.demo.dto;

import lombok.Data;

@Data
public class PatientResponseDTO {
	private Long id;
	private String name;
	private Integer age;
	private Long contactNumber;
	private String medicalHistory;
	private Long doctorId;
	private String doctorName;
}
