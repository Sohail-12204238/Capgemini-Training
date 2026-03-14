package com.example.demo.dto;


import java.time.LocalDate;

import lombok.Data;

@Data
public class AppointmentRequestDTO {

    private String appointmentNumber;

    private LocalDate appointmentDate;

    private Long patientId;

    private Long doctorId;

}
