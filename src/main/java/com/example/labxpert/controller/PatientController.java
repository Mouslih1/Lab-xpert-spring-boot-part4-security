package com.example.labxpert.controller;

import com.example.labxpert.Dtos.PatientDto;
import com.example.labxpert.exception.MessageErrorException.MessageError;
import com.example.labxpert.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final IPatientService iPatientService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Admin', 'Technicien', 'Responsable')")
    public ResponseEntity<List<PatientDto>> getAll()
    {
        return ResponseEntity.ok(iPatientService.getAll());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('Technicien', 'Responsable')")
    public ResponseEntity<PatientDto> save(@RequestBody @Valid PatientDto patientDto)
    {
        PatientDto patientSaved = iPatientService.add(patientDto);
        return new ResponseEntity<>(patientSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    @PreAuthorize("hasAnyAuthority('Technicien', 'Responsable')")
    public ResponseEntity<PatientDto> update(@RequestBody @Valid PatientDto patientDto, @PathVariable Long id)
    {
        PatientDto patientUpdated = iPatientService.update(id, patientDto);
        return new ResponseEntity<>(patientUpdated, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Admin', 'Technicien', 'Responsable')")
    public ResponseEntity<PatientDto> getById(@PathVariable Long id)
    {
        try{
            PatientDto patient = iPatientService.getById(id);
            return new ResponseEntity<>(patient, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/patient")
    @PreAuthorize("hasAnyAuthority('Admin', 'Technicien', 'Responsable')")
    public ResponseEntity<PatientDto> getByName(@RequestParam String name)
    {
        try{
            PatientDto patient = iPatientService.getByName(name);
            return  new ResponseEntity<>(patient, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/delete")
    @PreAuthorize("hasAnyAuthority('Admin','Responsable')")
    public ResponseEntity<MessageError> delete(@PathVariable Long id)
    {
        MessageError messageError = new MessageError("Patient deleted successfully.");
        iPatientService.delete(id);
        return new ResponseEntity<>(messageError, HttpStatus.OK);
    }
}
