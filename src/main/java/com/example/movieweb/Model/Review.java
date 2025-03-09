package com.example.movieweb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Float rating;
    @Column
    private String content;
    @ManyToOne
    @JoinColumn(name = "users")
    private User user;
    @ManyToOne
    @JoinColumn(name = "movie")
    private Movie movie;
}
