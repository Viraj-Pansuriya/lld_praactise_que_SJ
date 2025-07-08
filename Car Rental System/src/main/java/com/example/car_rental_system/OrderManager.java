package com.example.car_rental_system;

import com.example.car_rental_system.model.Location;
import com.example.car_rental_system.model.Store;
import com.example.car_rental_system.service.LocationDetectionService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Data
public class OrderManager {
    private final Map<String, Store> storeIdToStore = new HashMap<>();
    private final LocationDetectionService locationDetectionService;

    public OrderManager(LocationDetectionService locationDetectionService) {
        this.locationDetectionService = locationDetectionService;
    }

    public void registerStore(Store store) {
        storeIdToStore.put(String.valueOf(store.getStoreId()), store);
        locationDetectionService.addStoreToGeoIndex(store);
    }

    public List<Store> getLocationWiseStores(Location location, double radiusKm) {
        List<String> nearbyStoreIds = locationDetectionService.getNearestStoreIds(location, radiusKm);
        return nearbyStoreIds.stream()
                .map(storeIdToStore::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
