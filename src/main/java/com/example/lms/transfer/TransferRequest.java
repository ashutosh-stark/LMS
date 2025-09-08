package com.example.lms.transfer;

import java.util.UUID;

import com.example.lms.books.Books;
import com.example.lms.libary.Libary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransferRequest {
private String  transferId;
private Libary requestBranch ;
private Libary fullfilingBranch;
private String bookRequested ;
private int copies;
private TransferStatus transferStatus;
    

public TransferRequest(String transferId, Libary requestBranch, Libary fullfilingBranch, String bookRequested, 
int copies, TransferStatus transferStatus) {
    this.transferId = transferId;
    this.requestBranch = requestBranch;
    this.fullfilingBranch = fullfilingBranch;
    this.bookRequested = bookRequested;
    this.copies = copies;
    this.transferStatus = TransferStatus.TRANSFER_REQESTED;
}



}
