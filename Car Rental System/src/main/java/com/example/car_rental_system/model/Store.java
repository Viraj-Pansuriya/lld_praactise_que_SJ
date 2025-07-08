package com.example.car_rental_system.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class Store {
    private int storeId;
    private String storeName;
    private Location location;
    @ToString.Exclude
    private VehicleInventoryManager vehicleInventoryManager;
    @ToString.Exclude
    private List<Reservation> reservations;

    public Store(List<Vehicle> vehicles){
        Map<VehicleType , List<Vehicle>> vehicleListMap =
                vehicles.stream().collect(Collectors.groupingBy(Vehicle::getVehicleType));
        vehicleInventoryManager = new VehicleInventoryManager(vehicleListMap);
        reservations = new ArrayList<>();
    }

    public Reservation bookVehicle(LocalDateTime startTime , LocalDateTime endTime , Vehicle vehicle){
        boolean result = vehicleInventoryManager.bookVehicle(startTime , endTime , vehicle);

        if(result){
            Reservation reservation = new Reservation();
            reservation.setReservationId(UUID.randomUUID().toString());
            reservation.setReservationStatus(ReservationStatus.SCHEDULED);
            reservation.setVehicle(vehicle);
            reservation.setStore(this);
            reservation.setStartingTime(startTime);
            reservation.setEndingTime(endTime);
            reservations.add(reservation);
            return reservation;
        }
        return null;
    }

    public List<Vehicle> getVehiclesBasedOnType(VehicleType vehicleType){
            return vehicleInventoryManager.getVehicleBasedOnType(vehicleType);
    }

    public synchronized void completeReservation(String reservationId){
        Optional<Reservation> potentialReservation =
                reservations.stream().filter(r-> r.getReservationId().equals(reservationId)).findFirst();

        if(potentialReservation.isEmpty())
            throw new RuntimeException("Can not be found any valid reservation for given reservationId " + reservationId);

        potentialReservation.ifPresent(reservation -> reservation.setReservationStatus(ReservationStatus.COMPLETED));
    }
}
