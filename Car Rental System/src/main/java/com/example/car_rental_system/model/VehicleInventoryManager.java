package com.example.car_rental_system.model;

import java.time.LocalDateTime;
import java.util.*;

public class VehicleInventoryManager {
    private final Map<VehicleType , List<Vehicle>> vehicleInventory;

    public VehicleInventoryManager(Map<VehicleType, List<Vehicle>> vehicleInventory) {
        this.vehicleInventory = (vehicleInventory == null ? new EnumMap<>(VehicleType.class) : vehicleInventory) ;
    }

    public boolean bookVehicle(LocalDateTime startTime, LocalDateTime endTime, Vehicle vehicle) {
        return vehicle.checkAndBookVehicle(startTime, endTime);
    }

    public List<Vehicle> getVehicleBasedOnType(VehicleType vehicleType) {
        return vehicleInventory.get(vehicleType);
    }
}
