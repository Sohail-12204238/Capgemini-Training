package com.example.demo.mapper;


import com.example.demo.dto.AppointmentRequestDTO;
import com.example.demo.dto.AppointmentResponseDTO;
import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Status;

public class AppointmentMapper {

    public static Appointment toEntity(
            AppointmentRequestDTO dto,
            Patient patient,
            Doctor doctor) {

        Appointment appointment = new Appointment();

        appointment.setAppointmentNumber(dto.getAppointmentNumber());
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setStatus(Status.STATUS_BOOKED);

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointment;
    }

    public static AppointmentResponseDTO toDTO(Appointment appointment) {

        AppointmentResponseDTO dto = new AppointmentResponseDTO();

        dto.setId(appointment.getId());
        dto.setAppointmentNumber(appointment.getAppointmentNumber());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setStatus(appointment.getStatus());

        if (appointment.getPatient() != null) {
            dto.setPatientId(appointment.getPatient().getId());
            dto.setPatientName(appointment.getPatient().getName());
        }

        if (appointment.getDoctor() != null) {
            dto.setDoctorId(appointment.getDoctor().getId());
            dto.setDoctorName(appointment.getDoctor().getName());
        }

        return dto;
    }
}
