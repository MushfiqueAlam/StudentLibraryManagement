package com.library_management.studentLibraryManagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name="gender",nullable = false)
    private String gender;

    @Column(name="age",nullable = false)
    private int age;

    @Column(name = "semester",nullable = false)
    private String semester;

    @Column(name="mobile",nullable = false)
    private String mobile;

    @Column(name="department",nullable = false)
    private String departmet;

    @Column(name = "dob",nullable = false)
    private String dob;

    @JsonManagedReference
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;
}
