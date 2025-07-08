package com.example.car_rental_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReservationTime {
    LocalDateTime startTime;
    LocalDateTime endTime;
}
