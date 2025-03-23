package com.example.movieweb.Controller;

import com.example.movieweb.DTO.Request.AuthenticationRequest;
import com.example.movieweb.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService; ;
    @PostMapping(value = "/login")
    public boolean login(@RequestBody AuthenticationRequest authenticationRequest) {
        boolean result = authenticationService.authenticate(authenticationRequest);
        return result;
    }

}
