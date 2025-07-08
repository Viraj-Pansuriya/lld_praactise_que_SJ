package com.example.car_rental_system.model;

import lombok.Data;

@Data
public class Payment {
    private Bill bill;
    boolean isPaid;
}
