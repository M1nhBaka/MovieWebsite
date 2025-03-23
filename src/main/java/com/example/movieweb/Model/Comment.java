package com.example.movieweb.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "comment")
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content")
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
