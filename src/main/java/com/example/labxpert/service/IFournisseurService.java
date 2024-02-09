package com.example.labxpert.service;


import com.example.labxpert.Dtos.FournisseurDto;

import java.util.List;

public interface IFournisseurService {
    FournisseurDto add(FournisseurDto fournisseurDto);
    FournisseurDto update(Long id, FournisseurDto fournisseurDto);
    void delete(Long id);
    List<FournisseurDto> getAll();
    FournisseurDto getById(Long id);
    FournisseurDto getByName(String name);

    void validation(FournisseurDto fournisseurDto);

}
