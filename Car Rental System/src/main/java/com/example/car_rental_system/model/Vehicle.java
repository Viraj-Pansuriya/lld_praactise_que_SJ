package com.example.car_rental_system.model;

import com.sun.source.tree.Tree;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Data
public class Vehicle {
    private String vehicleId;
    private VehicleType vehicleType;
    private Long hourlyRate;
    private Long dailyRate;

    @ToString.Exclude
    private TreeSet<ReservationTime> upcomingReservationSlots = new TreeSet<>(Comparator.comparing(a -> a.startTime));

    private synchronized boolean isAbleToBook(LocalDateTime startTime , LocalDateTime endTime){

        // TODO : do it via binary search:
        boolean isAbleToBook = true;
        for(ReservationTime reservationTime : upcomingReservationSlots){
            if(!(endTime.isBefore(reservationTime.startTime) || startTime.isAfter(reservationTime.endTime))){
                isAbleToBook = false;
                break;
            }
        }

        return isAbleToBook;
    }

    synchronized boolean checkAndBookVehicle(LocalDateTime startTime , LocalDateTime endTime){
        if(isAbleToBook(startTime, endTime)){
            return bookVehicle(startTime , endTime);
        }
        return false;
    }

    private synchronized boolean bookVehicle(LocalDateTime startTime , LocalDateTime endTime){
        return upcomingReservationSlots.add(new ReservationTime(startTime , endTime));
    }


}
