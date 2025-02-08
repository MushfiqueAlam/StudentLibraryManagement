package com.library_management.studentLibraryManagement.service;

import com.library_management.studentLibraryManagement.convertor.BookConvertor;
import com.library_management.studentLibraryManagement.model.Author;
import com.library_management.studentLibraryManagement.model.Book;
import com.library_management.studentLibraryManagement.model.Card;
import com.library_management.studentLibraryManagement.repository.AuthorRepository;
import com.library_management.studentLibraryManagement.repository.BookRepository;
import com.library_management.studentLibraryManagement.repository.CardRepository;
import com.library_management.studentLibraryManagement.requestDto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    AuthorRepository authorRepository;

    public String savebook(BookRequestDto bookRequestDto){
        Book  book= BookConvertor.convertBookRequestDtoIntoBook(bookRequestDto);
        Card card=cardRepository.findById(bookRequestDto.getCardId()).orElseThrow(()->new RuntimeException("not found"+bookRequestDto.getCardId()));

        Author author=authorRepository.findById(bookRequestDto.getAuthorId()).orElseThrow(()->new RuntimeException("not found"+bookRequestDto.getCardId()));

        book.setCard(card);
//        card.setBookList(List<Book>);

        book.setAuthor(author);
        bookRepository.save(book);
        return "saved book successfully";
    }
}
