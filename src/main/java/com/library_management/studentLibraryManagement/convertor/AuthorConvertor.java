package com.library_management.studentLibraryManagement.convertor;

import com.library_management.studentLibraryManagement.model.Author;
import com.library_management.studentLibraryManagement.requestDto.AuthorRequestDto;

public class AuthorConvertor {

    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto){

        Author author=new Author();
        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setAbout(authorRequestDto.getAbout());
        author.setCountry(authorRequestDto.getCountry());
        author.setRating(authorRequestDto.getRating());
        author.setGender(authorRequestDto.getGender());
        return author;
    }
}
