package com.example.labxpert.service;

import com.example.labxpert.Dtos.PatientDto;

import java.util.List;

public interface IPatientService {
    PatientDto add(PatientDto patientDto);
    PatientDto update(Long id, PatientDto patientDto);
    void delete(Long id);
    List<PatientDto> getAll();
    PatientDto getById(Long id);
    PatientDto getByName(String name);
    void validation(PatientDto patientDto);
}
