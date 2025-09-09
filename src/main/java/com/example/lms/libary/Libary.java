package com.example.lms.libary;

import java.util.Date;

import com.example.lms.inventory.Inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Libary {
    private int librayId;
    private String branchName;
    private Inventory inventory;

}
