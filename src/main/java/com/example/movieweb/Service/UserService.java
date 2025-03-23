package com.example.movieweb.Service;

import com.example.movieweb.Converter.UserMapper;
import com.example.movieweb.DTO.UserDTO;
import com.example.movieweb.Model.User;
import com.example.movieweb.Repository.UserRepository;
import com.example.movieweb.Service.IService.IUserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    public User CreateUser(UserDTO userDTO) throws BadRequestException {
        if(!userRepository.existsByUsername(userDTO.getUsername())) throw new BadRequestException("Username already exists");
        User newUser = userMapper.toUser(userDTO);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(UserDTO userDTO)  {
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(Math.toIntExact(id));
    }
    public User getUserById(Long id) {
        return userRepository.findById(Math.toIntExact(id)).orElse(null);
    }
    public List<User> getUser(){
        return userRepository.findAll();
    }
}
