package com.example.movieweb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @Column
    private String comment;
}
