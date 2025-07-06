package com.example.car_rental_system.service;

import com.example.car_rental_system.model.Location;
import com.example.car_rental_system.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LocationDetectionService {
    private final RedisTemplate<String, String> redisTemplate;
    private static final String GEO_STORE_KEY = "store_locations";

    public LocationDetectionService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addStoreToGeoIndex(Store store) {
        GeoOperations<String, String> geoOps = redisTemplate.opsForGeo();
        Location location = store.getLocation();
        geoOps.add(GEO_STORE_KEY, new Point(location.getLongitude(), location.getLatitude()), String.valueOf(store.getStoreId()));
    }

    public List<String> getNearestStoreIds(Location location, double radiusKm) {
        GeoOperations<String, String> geoOps = redisTemplate.opsForGeo();
        Circle searchArea = new Circle(
                new Point(location.getLongitude(), location.getLatitude()),
                new Distance(radiusKm, Metrics.KILOMETERS)
        );

        GeoResults<RedisGeoCommands.GeoLocation<String>> results = geoOps.radius(GEO_STORE_KEY, searchArea);
        if (results == null) return Collections.emptyList();

        return results.getContent().stream()
                .map(GeoResult::getContent)
                .map(RedisGeoCommands.GeoLocation::getName)
                .collect(Collectors.toList());
    }
}
