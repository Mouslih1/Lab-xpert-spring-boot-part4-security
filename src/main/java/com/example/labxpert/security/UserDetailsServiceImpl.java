package com.example.labxpert.security;

import com.example.labxpert.Dtos.UserDto;
import com.example.labxpert.helper.JWTHelper;
import com.example.labxpert.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        UserDto user = iUserService.getByEmailInObject(email);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
        return new User(user.getEmail(), user.getPassword(), Collections.singleton(authority));
    }
}