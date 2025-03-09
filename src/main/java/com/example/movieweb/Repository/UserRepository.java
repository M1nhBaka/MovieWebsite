package com.example.movieweb.Repository;

import com.example.movieweb.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
