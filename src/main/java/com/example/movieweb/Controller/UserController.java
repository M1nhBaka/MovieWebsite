package com.example.movieweb.Controller;

import com.example.movieweb.DTO.UserDTO;
import com.example.movieweb.Model.User;
import com.example.movieweb.Service.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/profile")
    public String getUserProfile(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "user/profile";
    }

    @GetMapping("/profile/edit")
    public String showEditProfileForm(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "user/edit-profile";
    }

    @PostMapping("/profile/edit")
    public String updateProfile(@ModelAttribute UserDTO userDTO) {
        userService.updateUser(userDTO);
        return "redirect:/user/profile";
    }
}
