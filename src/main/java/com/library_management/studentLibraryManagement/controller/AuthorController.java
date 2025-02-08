package com.library_management.studentLibraryManagement.controller;

import com.library_management.studentLibraryManagement.requestDto.AuthorRequestDto;
import com.library_management.studentLibraryManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        String response=authorService.saveAuthor(authorRequestDto);
        return response;
    }
}
