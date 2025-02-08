package com.library_management.studentLibraryManagement.service;

import com.library_management.studentLibraryManagement.convertor.AuthorConvertor;
import com.library_management.studentLibraryManagement.model.Author;
import com.library_management.studentLibraryManagement.repository.AuthorRepository;
import com.library_management.studentLibraryManagement.requestDto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String saveAuthor(AuthorRequestDto authorRequestDto){
        Author  author= AuthorConvertor.convertAuthorRequestDtoIntoAuthor(authorRequestDto);
        authorRepository.save(author);
        return "Author has been successfully saved!";
    }

}
