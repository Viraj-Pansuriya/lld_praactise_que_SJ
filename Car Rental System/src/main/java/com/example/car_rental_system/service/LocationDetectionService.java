package com.example.car_rental_system.service;

import com.example.car_rental_system.model.Location;
import com.example.car_rental_system.model.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LocationDetectionService {
    public List<Store> getNearestStores(Location location , Map<Location , List<Store>> locations){
        // TODO : improve it with using redis geo hashLibrary:
        return locations.get(location);
    }
}
