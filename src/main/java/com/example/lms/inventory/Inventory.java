package com.example.lms.inventory;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.lms.books.Books;


import lombok.Getter;

@Getter
public class Inventory {
    private Map<Books,Integer> stock;
    private Date dateAdded;
    private Date lastAdded;
    private int inStock;
    private boolean Available;

    // So the inventory will be directly intracting with the book
    // Adding the books into the inventory

    public Inventory() {
        this.stock = new HashMap<>();
    }

   public void addBooks(Books book){
        // in order to add the book first check if there any book 
        // exist if so then increment the count otherwise add the
        // book and incment the count 
        stock.put(book, stock.getOrDefault(book,0)+1);
    }

    public void addBookByCount(Books book, int count){
        // in order to add the book first check if there any book 
        // exist if so then increment the count otherwise add the
        // book and incment the count 
        stock.put(book, stock.getOrDefault(book,0)+count);
    }

    // remove the book
    // if the book and remove the book
    // via decrementing it's count 
   public void removebook(Books book){
        if(stock.containsKey(book)){
            // then remove decrement the count
            // reduce the count
            stock.put(book, stock.get(book)-1);
           }else{
            System.out.println("The Boook is not in stock");
           }
    }

    public void removeBookByCount(Books book, int count){
        if(stock.containsKey(book)){
            // then remove decrement the count
            // reduce the count
            stock.put(book, stock.get(book)-count);
           }else{
            System.out.println("The Boook is not in stock");
           }
    } 

    // update the books
   public void update(Books be, int count){
        // so grab the book and update the details for the same
        if(!stock.containsKey(be)){
            System.out.println("The book doesn't exist in the inventory");
            return;
        }else{
            // otherwise update book count
            stock.put(be, count);
            return;
        }
    }

    // provide the searchig functionaly for the book
   public Books searchBook(String bookTitle, String bookAuthor, String ISBN){
        // iltrate over the hashMap and check with the particual value
        for(Map.Entry<Books,Integer> mp: stock.entrySet()){
            Books book = mp.getKey();
            if(bookAuthor != null && !bookAuthor.isEmpty() && book.getAuthor().equals(bookAuthor)){
                return book;
            }else if(bookTitle != null && !bookTitle.isEmpty() && book.getTitle().equals(bookTitle)){
                return book;
            }else{
                if((book.getIsbn().equals(ISBN)))
                return book;
            }
        }
        return null;
    }

    public List<Books> getAllBooksByAuthorName(String authorName){
        List<Books> booksList = new ArrayList<>();
        for(Map.Entry<Books,Integer> mp: stock.entrySet()){
            Books book = mp.getKey();
            if(authorName != null && !authorName.isEmpty() && book.getAuthor().equals(authorName)){
              booksList.add(book);
            }
        }
        return booksList;

    }

    public List<Books> getAllBooksByPublicationYear(int publicationYear){
        List<Books> booksList = new ArrayList<>();
        for(Map.Entry<Books,Integer> mp: stock.entrySet()){
            Books book = mp.getKey();
            if(book.getPublicationYear() == (publicationYear)){
              booksList.add(book);
            }
        }
        return booksList;

    }

    public int getBookCount(String bookTitle, String bookAuthor, String ISBN){
        for(Map.Entry<Books,Integer> mp: stock.entrySet()){
            Books book = mp.getKey();
            if(bookAuthor != null && !bookAuthor.isEmpty() && book.getAuthor().equals(bookAuthor)){
                return mp.getValue();
            }else if(bookTitle != null && !bookTitle.isEmpty() && book.getTitle().equals(bookTitle)){
                return mp.getValue();
            }else{
                if((book.getIsbn().equals(ISBN)))
                return mp.getValue();
            }
        }
        return 0;
    }



}
