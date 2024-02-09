package com.example.labxpert.controller;

import com.example.labxpert.Dtos.MaterialDto;
import com.example.labxpert.exception.MessageErrorException.MessageError;
import com.example.labxpert.service.IMaterialService;
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
@RequestMapping("/api/v1/materials")
public class MaterialController {

    private final IMaterialService iMaterialService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<List<MaterialDto>> getAll()
    {
        return ResponseEntity.ok(iMaterialService.getAll());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<MaterialDto> save(@RequestBody @Valid MaterialDto materialDto)
    {
        MaterialDto materialSaved = iMaterialService.add(materialDto);
        return new ResponseEntity<>(materialSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<MaterialDto> update(@PathVariable Long id, @RequestBody @Valid MaterialDto materialDto)
    {
        MaterialDto materialUpdated = iMaterialService.update(id, materialDto);
        return new ResponseEntity<>(materialUpdated,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<MaterialDto> getById(@PathVariable Long id)
    {
        try{
            MaterialDto material = iMaterialService.getById(id);
            return new ResponseEntity<>(material, HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}/delete")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<MessageError> delete(@PathVariable Long id)
    {
        MessageError messageError = new MessageError("Material deleted successfully.");
        iMaterialService.delete(id);
        return new ResponseEntity<>(messageError, HttpStatus.OK);
    }

    @GetMapping("/libelle")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<MaterialDto> getByLibelle(@RequestParam String libelle)
    {
        try{
            MaterialDto materialDto = iMaterialService.getByLibelle(libelle);
            return new ResponseEntity<>(materialDto, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/price")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<List<MaterialDto>> getByPriceBefore(@RequestParam double price)
    {
        try{
            List<MaterialDto> materialDto = iMaterialService.getByPriceBefore(price);
            return new ResponseEntity<>(materialDto, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/available-quantity")
    @PreAuthorize("hasAnyAuthority('Admin', 'Responsable')")
    public ResponseEntity<List<MaterialDto>> getByAvailableQuantityBefore(@RequestParam int availableQuantity)
    {
        try{
            List<MaterialDto> materialDto = iMaterialService.getByAvailableQuantityBefore(availableQuantity);
            return new ResponseEntity<>(materialDto, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
