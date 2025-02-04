package com.library_management.studentLibraryManagement.convertor;

import com.library_management.studentLibraryManagement.model.Transaction;
import com.library_management.studentLibraryManagement.requestDto.TransactionRequestDto;

public class TransactionConvertor {
    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){

        Transaction transaction=new Transaction();
        transaction.setTransactionType(transactionRequestDto.getTransactionType());
        transaction.setDueDate(transactionRequestDto.getDueDate());
        transaction.setFine(transactionRequestDto.getFine());


        return transaction;
    }
}
