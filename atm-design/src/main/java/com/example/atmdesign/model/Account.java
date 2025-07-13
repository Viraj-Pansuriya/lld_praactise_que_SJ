package com.example.atmdesign.model;

import lombok.Data;

@Data
public class Account {
    private int id;
    private int balance;
    private Card card;
}
