package com.example.car_rental_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private String reservationId;
    private User user;
    private Vehicle vehicle;
    private LocalDateTime startingTime;
    private LocalDateTime endingTime;
    private Store store;
    private ReservationStatus reservationStatus;


    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", user=" + user +
                ", vehicle=" + vehicle +
                ", store=" + store +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
