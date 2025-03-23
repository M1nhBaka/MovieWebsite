package com.example.movieweb.Converter;

import com.example.movieweb.DTO.UserDTO;
import com.example.movieweb.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;
    public UserDTO toUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
    public User toUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
