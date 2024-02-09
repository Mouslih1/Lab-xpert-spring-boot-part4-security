package com.example.labxpert.service;

import com.example.labxpert.Dtos.ReactifDto;

import java.util.List;

public interface IReactifService {
    ReactifDto add(ReactifDto reactifDto);
    ReactifDto update(Long id, ReactifDto reactifDto);
    void delete(Long id);
    List<ReactifDto> getAll();
    ReactifDto getById(Long id);
    ReactifDto getByName(String name);
    List<ReactifDto> getByQuantityStockBefore(int quantityStock);
    void validation(ReactifDto reactifDto);
}
