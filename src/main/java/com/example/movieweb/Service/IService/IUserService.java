package com.example.movieweb.Service.IService;

import com.example.movieweb.DTO.UserDTO;
import com.example.movieweb.Model.User;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface IUserService {
    public User CreateUser(UserDTO userDTO) throws BadRequestException ;
    public User updateUser(UserDTO userDTO);
    public void deleteUser(Long id) ;
    public User getUserById(Long id)  ;
    public List<User> getUser();
}
