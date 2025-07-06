package com.example.car_rental_system.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Bill {
    private Reservation reservation;
    private double amount;
    private LocalDateTime createdAt;
}
