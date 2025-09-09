package com.example.lms.lending;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.lms.books.Books;
import com.example.lms.inventory.Inventory;
import com.example.lms.members.Members;
import com.example.lms.reservation.ReservationService;

public class CheckOutService   {

    private ReservationService reservationService = new ReservationService();
    
    public String checkOutBook(Checkout checkout,  List<Books> book, Members member
    , Date borrowDate, Inventory inventory){
        // in order to check out book we need to create 
        // check book if the copies exists and reove it from the invetory
        for(Books br : book){
          int bookCount =  inventory.getBookCount(br.getTitle(),null,null);
          if(bookCount > 0){
            // remove the book from the inventory
            Books getBook = inventory.searchBook(br.getTitle(), null, null);
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
                return "Can't find the Book";
            }
            }else{
                // add the reservation of the book for the user
                if (reservationService == null) {
                    reservationService = new ReservationService();
                }
                reservationService.createReservation(member, br);
            }
        }
        // create a transaction id and provide the details like, status, dueDate
      
        return "Books is not availiable reservation created for "+member;

    }

    public String returnBook(Checkout checkout, List<Books> books, Members member, Inventory inventory){
        // return the book add the books into inventory
        if (inventory == null || books == null) {
            return "Invalid return request: inventory or books is null";
        }
        for(Books br : books){
            if (br == null) {
                continue;
            }
            inventory.addBooks(br);
            // change the status   
            checkout.setStatus(LendingStatus.RETURNED);
            if (reservationService != null) {
                reservationService.notifyMember(br);
            }
        }
        checkout.setActualReturnDate(new java.util.Date());
          return "Txnid: "+checkout.getTransactionId()+ "Status: "+checkout.getStatus()+" by: "+member.getName();
          
    }
}
