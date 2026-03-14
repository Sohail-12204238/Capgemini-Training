package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DoctorRequestDTO;
import com.example.demo.dto.DoctorResponseDTO;

public interface DoctorService {
	DoctorResponseDTO createDoctor(DoctorRequestDTO dto);
}
