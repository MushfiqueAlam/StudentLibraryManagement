package com.library_management.studentLibraryManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.library_management.studentLibraryManagement.enums.Category;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "pages",nullable = false)
    private String pages;

    @Column(name = "publisher_name",nullable = false)
    private String publisherName;

    @Column(name = "publish_date",nullable = false)
    public String publishDate;

    @Column(name="category",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(name = "rackNo",nullable = false)
    private String rackNo;

    @Column(name = "availability",nullable = false)
    private boolean availability;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;

    @JsonManagedReference
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction>transactionList=new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Author author;
}
