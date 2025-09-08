package com.example.lms.reservation;

import java.util.Date;

import com.example.lms.books.Books;
import com.example.lms.members.Members;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation {
private int reservationId;
private Members member;
private Books book;
private ReservationStatus reservationStatus;
private Date reservationDate;
    
public Reservation(int reservationId, Members member, Books book, Date reservationDate) {
    this.reservationId = reservationId;
    this.member = member;
    this.book = book;
    this.reservationStatus = ReservationStatus.RESERVED_PENDING;
    this.reservationDate = reservationDate;
}

}
