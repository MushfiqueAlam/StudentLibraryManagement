package com.library_management.studentLibraryManagement.convertor;

import com.library_management.studentLibraryManagement.model.Student;
import com.library_management.studentLibraryManagement.requestDto.StudentRequestDto;

public class StudentConvertor {
    public static Student convertStudentRequestDtoIntoStudent(StudentRequestDto studentRequestDto){
        Student student=new Student();

        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setAge(studentRequestDto.getAge());
        student.setGender(studentRequestDto.getGender());
        student.setDepartmet(studentRequestDto.getDepartment());
        student.setDob(studentRequestDto.getDob());
        student.setSemester(studentRequestDto.getSemester());
        student.setMobile(studentRequestDto.getMobile());

        return student;
    }
}
