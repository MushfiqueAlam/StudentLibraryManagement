package com.library_management.studentLibraryManagement.requestDto;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private String name;
    private String email;
    private String country;
    private String about;
    private double rating;
    private String gender;

}
