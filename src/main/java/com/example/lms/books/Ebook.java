package com.example.lms.books;

public class Ebook extends Books {
    
    private String downloadUrl;

    public Ebook(String title, String author, String isbn, int publicationYear, String downloadUrl) {
        super(title,author,isbn,publicationYear);
        this.downloadUrl = downloadUrl;
    }
}
