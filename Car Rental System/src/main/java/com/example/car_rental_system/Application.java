package com.example.car_rental_system;

import com.example.car_rental_system.config.RedisConfig;
import com.example.car_rental_system.model.*;
import com.example.car_rental_system.service.LocationDetectionService;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {
        // 1. Create Locations (lat, long)
        Location newYorkLocation = new Location(40.7128, -74.0060);     // New York
        Location laLocation = new Location(34.0522, -118.2437);
        Location delhiLocation = new Location( 28.6315, 77.2167);

        // 2. Create Vehicles
        Vehicle sedan = new Vehicle();
        sedan.setVehicleId("SED001");
        sedan.setVehicleType(VehicleType.CAR);
        sedan.setHourlyRate(12L);
        sedan.setDailyRate(70L);

        Vehicle suv = new Vehicle();
        suv.setVehicleId("SUV001");
        suv.setVehicleType(VehicleType.CAR);
        suv.setHourlyRate(18L);
        suv.setDailyRate(100L);

        // 3. Create Stores and assign vehicles
        Store nyStore = new Store(List.of(sedan, suv));
        nyStore.setStoreId(1);
        nyStore.setStoreName("New York Downtown Store");
        nyStore.setLocation(newYorkLocation);

        Store laStore = new Store(List.of(suv));
        laStore.setStoreId(2);
        laStore.setStoreName("LA Central Store");
        laStore.setLocation(laLocation);

        Store delhiStore = new Store(List.of(suv,sedan));
        delhiStore.setStoreId(3);
        delhiStore.setStoreName("Delhi Central Store");
        delhiStore.setLocation(delhiLocation);

        // 4. Map stores by Location
//        Map<Location, List<Store>> locationWiseStores = new HashMap<>();
//        locationWiseStores.put(newYorkLocation, List.of(nyStore));
//        locationWiseStores.put(laLocation, List.of(laStore));


        // 5. Initialize OrderManager
        LocationDetectionService locationDetectionService = new LocationDetectionService(RedisConfig.createRedisTemplate());
        OrderManager orderManager = new OrderManager(locationDetectionService);
        orderManager.registerStore(laStore);
        orderManager.registerStore(nyStore);
        orderManager.registerStore(delhiStore);

        // 6. Usage example
        List<Store> storesNearBy = orderManager.getLocationWiseStores(new Location(28.529, 77.2295 ), 30);
        System.out.println("Stores near by:");
        for (Store store : storesNearBy) {
            System.out.println(" - " + store.getStoreName());
        }

        if(CollectionUtils.isEmpty(storesNearBy)){
            System.out.println("No near by  Found");
            return ;
        }

        Store store = storesNearBy.getFirst();
        List<Vehicle> vehicles = store.getVehiclesBasedOnType(VehicleType.CAR);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // just to check concurrency;
        for(int index = 0 ; index < 2 ; index++){
            int finalIndex = index;
            executorService.submit(()->
            {
                boolean resp = store.bookVehicle(
                        LocalDateTime.of(2025, 7, 7, 12, 0, 0),
                        LocalDateTime.of(2025, 7, 8, 12, 0, 0),
                        vehicles.getFirst());

                System.out.println("Vehicle Booked at index : " + finalIndex + " with response " +  resp);
            });
        }

        executorService.shutdown();


    }
}
