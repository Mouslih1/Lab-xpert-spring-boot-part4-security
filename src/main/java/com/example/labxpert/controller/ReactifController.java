package com.example.labxpert.controller;

import com.example.labxpert.Dtos.ReactifDto;
import com.example.labxpert.exception.MessageErrorException.MessageError;
import com.example.labxpert.service.IReactifService;
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
@RequestMapping("/api/v1/reactifs")
public class ReactifController {

    private final IReactifService iReactifService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Admin', 'Technicien', 'Responsable')")
    public ResponseEntity<List<ReactifDto>> getAll()
    {
        return ResponseEntity.ok(iReactifService.getAll());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<ReactifDto> save(@RequestBody @Valid ReactifDto reactifDto)
    {
        ReactifDto reactifSaved = iReactifService.add(reactifDto);
        return new ResponseEntity<>(reactifSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<ReactifDto> update(@RequestBody @Valid ReactifDto reactifDto, @PathVariable Long id)
    {
        ReactifDto reactifUpdated = iReactifService.update(id, reactifDto);
        return new ResponseEntity<>(reactifUpdated, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<ReactifDto> getById(@PathVariable Long id)
    {
        try{
            ReactifDto reactif = iReactifService.getById(id);
            return new ResponseEntity<>(reactif, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reactif")
    @PreAuthorize("hasAnyAuthority('Admin', 'Technicien', 'Responsable')")
    public ResponseEntity<ReactifDto> getByName(@RequestParam String name)
    {
        try{
            ReactifDto reactif = iReactifService.getByName(name);
            return  new ResponseEntity<>(reactif, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/delete")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<MessageError> delete(@PathVariable Long id)
    {
        MessageError messageError = new MessageError("Reactif deleted successfully.");
        iReactifService.delete(id);
        return new ResponseEntity<>(messageError, HttpStatus.OK);
    }

    @GetMapping("/quantity-stock")
    @PreAuthorize("hasAnyAuthority('Admin', 'Technicien' ,'Responsable')")
    public ResponseEntity<List<ReactifDto>> getByQuantityStockBefore(@RequestParam(name = "quantity-stock") int quantityStock)
    {
        try{
            List<ReactifDto> reactifs = iReactifService.getByQuantityStockBefore(quantityStock);
            return  new ResponseEntity<>(reactifs, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
