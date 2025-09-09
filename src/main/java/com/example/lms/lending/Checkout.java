package com.example.lms.lending;

import java.util.Date;
import java.util.List;

import com.example.lms.books.Books;
import com.example.lms.members.Members;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Checkout{
    
    private String transactionId;
    private List<Books> borrwBooks;
    private Members members;
    private Date dueDate;
    private Date borrowDate;
    private LendingStatus status;
    private Date actualReturnDate;



}




