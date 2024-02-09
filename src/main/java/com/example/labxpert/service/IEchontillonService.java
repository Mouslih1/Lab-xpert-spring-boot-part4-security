package com.example.labxpert.service;

import com.example.labxpert.Dtos.EchontillonDto;

import java.util.List;

public interface IEchontillonService {
    EchontillonDto add(EchontillonDto echontillonDto);
    EchontillonDto update(Long id, EchontillonDto echontillonDto);
    void delete(Long id);
    List<EchontillonDto> getAll();
    EchontillonDto getById(Long id);
    EchontillonDto getByCodeEchontillon(String codeEchontillon);
    void validation(EchontillonDto echontillonDto);
}
