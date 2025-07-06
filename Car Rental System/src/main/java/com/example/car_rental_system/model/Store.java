package com.example.car_rental_system.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class Store {
    private int storeId;
    private String storeName;
    private Location location;
    private VehicleInventoryManager vehicleInventoryManager;
    private List<Reservation> reservations;

    public Store(List<Vehicle> vehicles){
        Map<VehicleType , List<Vehicle>> vehicleListMap =
                vehicles.stream().collect(Collectors.groupingBy(Vehicle::getVehicleType));
        vehicleInventoryManager = new VehicleInventoryManager(vehicleListMap);
    }

    public boolean bookVehicle(LocalDateTime startTime , LocalDateTime endTime , Vehicle vehicle){
        return vehicleInventoryManager.bookVehicle(startTime , endTime , vehicle);
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
