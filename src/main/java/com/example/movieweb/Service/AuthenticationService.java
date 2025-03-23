package com.example.movieweb.Service;

import com.example.movieweb.DTO.Request.AuthenticationRequest;
import com.example.movieweb.Model.User;
import com.example.movieweb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthenticationService {
    @Autowired
    UserRepository userRepository;
    public boolean authenticate(AuthenticationRequest authenticationRequest) {
        User user = userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
    }
}
