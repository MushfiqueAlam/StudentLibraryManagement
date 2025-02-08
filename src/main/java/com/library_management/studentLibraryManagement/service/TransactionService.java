package com.library_management.studentLibraryManagement.service;

import com.library_management.studentLibraryManagement.convertor.TransactionConvertor;
import com.library_management.studentLibraryManagement.model.Book;
import com.library_management.studentLibraryManagement.model.Card;
import com.library_management.studentLibraryManagement.model.Transaction;
import com.library_management.studentLibraryManagement.repository.BookRepository;
import com.library_management.studentLibraryManagement.repository.CardRepository;
import com.library_management.studentLibraryManagement.repository.TransactionRepository;
import com.library_management.studentLibraryManagement.requestDto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;

    public String saveTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction= TransactionConvertor.convertTransactionRequestDtoIntoTransaction(transactionRequestDto);
        Book book =bookRepository.findById(transactionRequestDto.getBookId()).orElseThrow(()->new RuntimeException("Not found"));
        Card card=cardRepository.findById(transactionRequestDto.getCardId()).orElseThrow(()->new RuntimeException("not found"));
        transaction.setBook(book);
        transaction.setCard(card);
        transactionRepository.save(transaction);
        return "transaction Successfull";
    }
}
