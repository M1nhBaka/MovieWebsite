package com.example.movieweb.Controller;

import com.example.movieweb.DTO.Request.AuthenticationRequest;
import com.example.movieweb.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("authRequest", new AuthenticationRequest());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AuthenticationRequest authenticationRequest) {
        boolean result = authenticationService.authenticate(authenticationRequest);
        if (result) {
            return "redirect:/movie";
        }
        return "redirect:/auth/login?error=true";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/auth/login";
    }
}
