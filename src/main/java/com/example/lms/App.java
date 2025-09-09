package com.example.lms;



import java.util.Date;
import java.util.UUID;

import com.example.lms.books.BookFactory;
import com.example.lms.books.Books;
import com.example.lms.inventory.Inventory;
import com.example.lms.lending.CheckOutService;
import com.example.lms.lending.Checkout;
import com.example.lms.libary.Libary;
import com.example.lms.members.Members;
import com.example.lms.transfer.TransferRequest;
import com.example.lms.transfer.TransferService;

/**
 * Driver Class
 *
 */
public class App 
{

   
    public static void main( String[] args )
    {
        
        // create the instances of libary, inventory, books
        Inventory inventory = new Inventory();
        Libary libary = new Libary(12, "City Libary 1", inventory);
        // so we need to intract with the libary not with the inventory directly
        //Create books
        CheckOutService checkOutService = new CheckOutService();

        Books effectiveJava = BookFactory.createBook("physical", "Effective Java", "Joshua Bloch", "12345", 2018, null);
        Books HarryPoter = BookFactory.createBook("physical", "Harry Poter", "J. K. Rowling", "4323", 2002, null);
        Books atomicHabit = BookFactory.createBook("physical", "Atomic habit", "James Clear", "7443", 2019, null);
         
        // add the books in the inventory
        libary.getInventory().addBookByCount(atomicHabit,10);
        libary.getInventory().addBookByCount(effectiveJava, 1);
        libary.getInventory().addBookByCount(HarryPoter, 20);

        // create memebers of the libary
        Members m1Members = new Members(23, "Ashutosh", "FinLand");
        Members m3Members = new Members(12, "Ravi", "sillicon vally");
        
        // let a memeber do the check of the book
        Checkout checkout = new Checkout();
        System.out.println(checkOutService.checkOutBook(checkout, java.util.Arrays.asList(atomicHabit,HarryPoter), m3Members, new Date(), inventory));
        Checkout checkout2 = new Checkout();
        System.out.println(checkOutService.checkOutBook(checkout2, java.util.Arrays.asList(effectiveJava,HarryPoter), m1Members, new Date(), inventory));

        // okay after checking out
        // lets see when a book is not avalble
        Checkout checkout3 = new Checkout();
        System.out.println("Going for out of stock checkOut");
        System.out.println(checkOutService.checkOutBook(checkout3, java.util.Arrays.asList(effectiveJava,HarryPoter), m1Members, new Date(), inventory));

          // lets return the book

          System.out.println(checkOutService.returnBook(checkout2, java.util.Arrays.asList(effectiveJava,HarryPoter), m1Members, inventory));
        
          // In order to create a diffrent branch we can create a diffrent 
          // libary object with diffrent inventory
          Inventory cityLibaryInventory = new Inventory();
          Libary cityLibary2 = new Libary(0, null, cityLibaryInventory);

          TransferRequest transferRequest = new TransferRequest(UUID.randomUUID().toString(),
          cityLibary2, libary, "Harry Poter",4);


          TransferRequest transferRequest2 = new TransferRequest(UUID.randomUUID().toString(),
          cityLibary2, libary, "Effective Java",100);

          TransferService transferService = new TransferService();
          transferService.executeInterTransfer(transferRequest);
          transferService.executeInterTransfer(transferRequest2);


          
    }
}
