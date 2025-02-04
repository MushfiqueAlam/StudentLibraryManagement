package com.library_management.studentLibraryManagement.convertor;

import com.library_management.studentLibraryManagement.model.Book;
import com.library_management.studentLibraryManagement.requestDto.BookRequestDto;

public class BookConvertor {

    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto){
        Book book=new Book();

        book.setTitle(bookRequestDto.getTitle());
        book.setPages(bookRequestDto.getPages());
        book.setCategory(bookRequestDto.getCategory());
        book.setAvailability(bookRequestDto.isAvailability());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setPublishDate(bookRequestDto.getPublishDate());
        book.setRackNo(bookRequestDto.getRackNo());

        return book;
    }
}
