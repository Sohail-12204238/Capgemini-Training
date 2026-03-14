package com.example.demo.dto;

import lombok.Data;

@Data
public class DoctorResponseDTO {

    private Long id;

    private String name;

    private String speciality;

    private Integer yearsOfExperience;

}
