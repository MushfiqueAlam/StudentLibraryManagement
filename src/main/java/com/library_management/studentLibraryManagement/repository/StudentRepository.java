package com.library_management.studentLibraryManagement.repository;

import com.library_management.studentLibraryManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public Student findByEmail(String email);
    public List<Student> findBydepartment(String department);
    public List<Student>findBySemesterAndDepartment(String semester,String department);
    public List<Student>findBySemesterOrDepartment(String semester,String department);
}
