package com.example.lms.transfer;

import java.util.UUID;

import com.example.lms.books.Books;
import com.example.lms.libary.Libary;
import com.example.lms.libarylms.LibaryLMS;

import lombok.Getter;
import lombok.Setter;



public class TransferService {


   public void executeInterTransfer(TransferRequest transferRequest){
        // First we need to search the book in the requested libary
        int bookCount = transferRequest.getFullfilingBranch().getInventory().getBookCount(transferRequest.getBookRequested(), null, null);
        if(bookCount >= transferRequest.getCopies()){
            // then go for the transfer
            // and change the transfer request status
           Books be = transferRequest.getFullfilingBranch().getInventory().searchBook(transferRequest.getBookRequested(), null, null);
            transferRequest.getFullfilingBranch().getInventory().removeBookByCount(be, bookCount);
            // add the book in the request libaray inventory
            transferRequest.getRequestBranch().getInventory().addBookByCount(be, bookCount);
            transferRequest.setTransferStatus(TransferStatus.TRANSFER_COMPLETED);
            System.out.println("Requested Transfer status: "+transferRequest.getTransferStatus());
        }else{
            // otherwise cancel the request and change the status
            transferRequest.setTransferStatus(TransferStatus.TRANSFER_DENIED);
            System.out.println("Requested Transfer status: "+transferRequest.getTransferStatus());   
        }
    }
    
    // public TransferRequest createTransferRequest(Libary reqestingLibary, Libary fullfilingLibary, int copies
    // , String bookRequested ){
    //    return new TransferRequest(UUID.randomUUID().toString(),reqestingLibary,
    //    fullfilingLibary,bookRequested,copies,TransferStatus.TRANSFER_REQESTED);
    
    // }

}
