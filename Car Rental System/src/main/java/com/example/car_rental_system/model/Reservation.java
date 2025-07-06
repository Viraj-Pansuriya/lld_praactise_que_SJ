package com.example.car_rental_system.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reservation {
    private String reservationId;
    private User user;
    private Vehicle vehicle;
    private LocalDateTime startingTime;
    private LocalDateTime endingTime;
    private Store store;
    private ReservationStatus reservationStatus;
}
