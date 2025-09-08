package com.example.lms.reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.lms.books.Books;
import com.example.lms.members.Members;

public class ReservationService {

    List<Reservation> reservationsList = new ArrayList<>();

    // create reservation for the user


    public Reservation createReservation(Members member, Books book) {
        Reservation reservation = new Reservation(
            reservationsList.size() + 1,
            member,
            book,
            new Date()
        );
        reservationsList.add(reservation);
        System.out.println("Reservation created for " + member.getName() + " on book: " + book.getTitle());
        return reservation;
    }
    

    public void notifyMember(Books books){
        // check for the book reservation is exist
        for(Reservation re : reservationsList){
            if(re.getBook().equals(books)){
                System.out.println("notification send to: "+re.getMember().getName()+" on email "+re.getMember().getName());
                re.setReservationStatus(ReservationStatus.RESERVED_COMPLETED);
            }
        }
    }

}
