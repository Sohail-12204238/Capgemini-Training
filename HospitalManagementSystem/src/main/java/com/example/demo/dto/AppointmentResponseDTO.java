package com.example.demo.dto;


import java.time.LocalDate;
import com.example.demo.model.Status;
import lombok.Data;

@Data
public class AppointmentResponseDTO {

    private Long id;

    private String appointmentNumber;

    private LocalDate appointmentDate;

    private Status status;

    private Long patientId;

    private String patientName;

    private Long doctorId;

    private String doctorName;

}
