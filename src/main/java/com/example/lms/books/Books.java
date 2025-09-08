package com.example.lms.books;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Books {
    private String title;
    private String author;
    private String isbn;
    private Date publicationYear;

    public Books(String title, String author, String isbn, Date publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

}
