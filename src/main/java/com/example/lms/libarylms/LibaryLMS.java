package com.example.lms.libarylms;

import java.util.List;
import java.util.UUID;

import com.example.lms.books.Books;
import com.example.lms.libary.Libary;
import com.example.lms.transfer.TransferRequest;
import com.example.lms.transfer.TransferService;
import com.example.lms.transfer.TransferStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibaryLMS {
    
    TransferService transferService;


   void executeIntertransfer(TransferRequest transferRequest){
    transferService.executeInterTransfer(transferRequest);
    }

}
