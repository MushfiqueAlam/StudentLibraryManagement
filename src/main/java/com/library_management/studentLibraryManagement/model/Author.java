package com.library_management.studentLibraryManagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "country",nullable = false)
    private String country;

    @Column(name = "about")
    private String about;

    @Column(name = "rating")
    private double rating;

    @Column(name = "gender")
    private String gender;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
//    private List<Book> bookList=new ArrayList<>();
}
