package com.example.movieweb.Repository;

import com.example.movieweb.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Long, Review> {
}
