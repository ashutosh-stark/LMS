package com.example.lms.lending;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.example.lms.books.Books;
import com.example.lms.inventory.Inventory;
import com.example.lms.members.Members;
import com.example.lms.reservation.ReservationService;

public class CheckOutService   {

    ReservationService reservationService;
    
    public String checkOutBook(Checkout checkout,  List<Books> book, Members member
    , Date borrowDate, Inventory inventory){
        // in order to check out book we need to create 
        // check book if the copies exists and reove it from the invetory
        for(Books br : book){
          Books getBook =  inventory.searchBook(br.getTitle(),"","");
            // remove the book from the inventory
            if(getBook != null){
                inventory.removebook(getBook);
                checkout.setStatus(LendingStatus.BOOK_ISSUED);
                checkout.setTransactionId(UUID.randomUUID().toString());
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, 14);
                checkout.setDueDate(calendar.getTime());
                member.getTransactionHistory().add(checkout);
                return "Txnid: "+checkout.getTransactionId()+" DueDate: "+checkout.getDueDate().toString()+" Txn status: "+checkout.getStatus();
            }else{

                // add the reservation of the book for the user
                reservationService.createReservation(member, br);
            }
        }
        // create a transaction id and provide the details like, status, dueDate
      
        return "Books is not availiable reservation created for "+member;

    }

    public String returnBook(Checkout checkout, List<Books> books, Members member, Inventory inventory){
        // return the book add the books into inventory
        for(Books br : books){
            inventory.addBooks(br);
            // change the status   
            checkout.setStatus(LendingStatus.RETURNED);
            reservationService.notifyMember(br);
        }
        checkout.setActualReturnDate(new java.util.Date());
          return "Txnid: "+checkout.getTransactionId()+ "Status: "+checkout.getStatus()+" by: "+member;
    }
}
