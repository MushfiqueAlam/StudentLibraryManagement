package com.library_management.studentLibraryManagement.repository;

import com.library_management.studentLibraryManagement.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
