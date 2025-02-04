package com.library_management.studentLibraryManagement.requestDto;

import lombok.Data;

@Data
public class StudentRequestDto {

    private String name;
    private String email;
    private String gender;
    private int age;
    private String semester;
    private String mobile;
    private String dob;
    private String department;

}
