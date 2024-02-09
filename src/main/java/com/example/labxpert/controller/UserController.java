package com.example.labxpert.controller;

import com.example.labxpert.Dtos.UserDto;
import com.example.labxpert.exception.MessageErrorException.MessageError;
import com.example.labxpert.service.IUserService;
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
@RequestMapping("/api/v1/users")
public class UserController {

    private final IUserService iUserService;

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<List<UserDto>> getAll()
    {
        return ResponseEntity.ok(iUserService.getAll());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserDto userDto)
    {
        UserDto userSaved = iUserService.add(userDto);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Valid UserDto userDto)
    {
        UserDto userUpdated = iUserService.update(id, userDto);
        return new ResponseEntity<>(userUpdated,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<UserDto> getById(@PathVariable Long id)
    {
        try{
            UserDto userDto = iUserService.getById(id);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}/delete")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<MessageError> delete(@PathVariable Long id)
    {
        MessageError messageError = new MessageError("Material deleted successfully.");
        iUserService.delete(id);
        return new ResponseEntity<>(messageError, HttpStatus.OK);
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<UserDto> getByName(@RequestParam String name)
    {
        try{
            UserDto user = iUserService.getByName(name);
            return  new ResponseEntity<>(user, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
