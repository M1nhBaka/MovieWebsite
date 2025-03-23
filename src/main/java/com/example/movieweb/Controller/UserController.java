package com.example.movieweb.Controller;


import com.example.movieweb.Service.IService.IUserService;
import com.example.movieweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/user")
public class UserController {
    @Autowired
    IUserService userService;



}
