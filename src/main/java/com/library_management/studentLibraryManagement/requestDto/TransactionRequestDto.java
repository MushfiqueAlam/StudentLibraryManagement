package com.library_management.studentLibraryManagement.requestDto;

import com.library_management.studentLibraryManagement.enums.TransactionType;
import lombok.Data;

@Data
public class TransactionRequestDto {

    private TransactionType transactionType;
    private String dueDate;
    private double fine;
    private int bookId;
    private int cardId;
}
