package com.library_management.studentLibraryManagement.controller;

import com.library_management.studentLibraryManagement.requestDto.TransactionRequestDto;
import com.library_management.studentLibraryManagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        String response=transactionService.saveTransaction(transactionRequestDto);
        return response;
    }
}
