package com.example.lms.members;

import java.util.ArrayList;
import java.util.List;

import com.example.lms.lending.Checkout;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Members {
    private int id;
    private String name;
    private String address;
    private String email;
    private List<Checkout> TransactionHistory;


    // method to directly update the inforrmation of the user
    boolean update(String name, String address, String email){
        if(name != null){
            this.name = name;
        }
        if(address != null){
            this.address = address;
        }
        if(email != null){
            this.email = email;
        }
        return true;
    }

    // Constructor
    public Members(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.TransactionHistory = new ArrayList<>();
    }

}
