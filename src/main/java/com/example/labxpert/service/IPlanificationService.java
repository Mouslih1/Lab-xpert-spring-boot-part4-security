package com.example.labxpert.service;

import com.example.labxpert.Dtos.PlanificationDto;

import java.util.List;

public interface IPlanificationService {
    PlanificationDto add(PlanificationDto planificationDto);
    PlanificationDto update(Long id, PlanificationDto planificationDto);
    void delete(Long id);
    List<PlanificationDto> getAll();
    PlanificationDto getById(Long id);
    void validation(PlanificationDto planificationDto);

}
