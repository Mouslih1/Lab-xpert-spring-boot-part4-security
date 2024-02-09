package com.example.labxpert.controller;

import com.example.labxpert.Dtos.ResultDto;
import com.example.labxpert.exception.MessageErrorException.MessageError;
import com.example.labxpert.service.IResultService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/results")
public class ResultatController {

    private final IResultService iResultService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Admin','Technicien', 'Responsable')")
    public ResponseEntity<List<ResultDto>> getAll()
    {
        return ResponseEntity.ok(iResultService.getAll());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<ResultDto> save(@RequestBody @Valid ResultDto resultDto)
    {
        ResultDto resultSaved = iResultService.add(resultDto);
        return new ResponseEntity<>(resultSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<ResultDto> update(@PathVariable Long id, @RequestBody @Valid ResultDto resultDto)
    {
        ResultDto resultUpdated = iResultService.update(id, resultDto);
        return new ResponseEntity<>(resultUpdated, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Admin','Technicien' , 'Responsable')")
    public ResponseEntity<ResultDto> getById(@PathVariable Long id)
    {
        try{
            ResultDto result = iResultService.getById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/delete")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<MessageError> delete(@PathVariable Long id)
    {
        MessageError messageError = new MessageError("Sous analyse deleted successfully.");
        iResultService.delete(id);
        return new ResponseEntity<>(messageError, HttpStatus.OK);
    }
}
