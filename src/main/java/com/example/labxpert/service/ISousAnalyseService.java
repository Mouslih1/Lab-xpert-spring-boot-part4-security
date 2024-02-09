package com.example.labxpert.service;

import com.example.labxpert.Dtos.SousAnalyseDto;
import com.example.labxpert.model.Reactif;

import java.util.List;

public interface ISousAnalyseService {
    SousAnalyseDto add(SousAnalyseDto sousAnalyseDto);
    SousAnalyseDto update(Long id, SousAnalyseDto sousAnalyseDto);
    void delete(Long id);
    List<SousAnalyseDto> getAll();
    SousAnalyseDto getById(Long id);
    SousAnalyseDto getByTitle(String title);
    void changeQuantityStockOfReactif(Reactif reactif);
    void validation(SousAnalyseDto sousAnalyseDto);

}
