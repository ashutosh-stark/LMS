package com.example.lms.libary;

import java.util.Date;

import com.example.lms.inventory.Inventory;

import lombok.Getter;

@Getter
public class Libary {
    private int librayId;
    private String branchName;
    private Date openingHours;
    private Date closingHours;
    private Inventory inventory;

}
