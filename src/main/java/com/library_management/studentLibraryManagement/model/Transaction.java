package com.library_management.studentLibraryManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.library_management.studentLibraryManagement.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name="transaction_type",nullable = false)
    private TransactionType transactionType;

    @CreationTimestamp
    @Column(name = "transaction_date",nullable = false)
    private Date transactionDate;

    @Column(name = "due_date",nullable = false)
    private String dueDate;

    @Column(name="fine",nullable = false)
    private double fine;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Book book;
}
