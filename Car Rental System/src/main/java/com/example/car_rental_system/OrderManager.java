package com.example.car_rental_system;

import com.example.car_rental_system.model.Location;
import com.example.car_rental_system.model.Store;
import com.example.car_rental_system.service.LocationDetectionService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class OrderManager {

    private Map<Location , List<Store>> locationWiseStores;
    private final LocationDetectionService locationDetectionService;

    public OrderManager(LocationDetectionService locationDetectionService) {
        this.locationDetectionService = locationDetectionService;
    }


    public List<Store> getLocationWiseStores(Location location) {
        return locationDetectionService.getNearestStores(location , locationWiseStores);
    }

    private List<Store> getNearestLocationStores(Location location) {
        return locationWiseStores.get(location);
    }



}
