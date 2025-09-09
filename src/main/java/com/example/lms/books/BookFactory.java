package com.example.lms.books;

import java.util.Date;

public class BookFactory {

    public static Books createBook(String type, String title, String author, String isbn, int year, String extra) {
        switch (type.toLowerCase()) {
            case "physical":
                return new PhysicalBook(title, author, isbn, year);
            case "ebook":
                return new Ebook(title, author, isbn, year, extra);
            default:
                throw new IllegalArgumentException("Unknown book type: " + type);
        }
    }
}
