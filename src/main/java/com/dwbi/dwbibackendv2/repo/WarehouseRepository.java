package com.dwbi.dwbibackendv2.repo;


import com.dwbi.dwbibackendv2.model.Trip;
import com.dwbi.dwbibackendv2.model.warehouse.CompletedAndCancelledTripsEachCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;



public interface WarehouseRepository extends JpaRepository<Trip, Integer> {

    @Query(value = "SELECT status AS tripStatus, COUNT(trip_id) AS tripCount, CITY AS city\n" +
            "                                FROM trip_dw trip, location_dw location\n" +
            "                                WHERE trip.LOCATION_START_ID = location.LOCATION_ID\n" +
            "                                GROUP BY status, CITY\n" +
            "                                ORDER BY COUNT(trip_id) DESC", nativeQuery = true)
    List<CompletedAndCancelledTripsEachCity> getCompletedCancelledTripStats();

}
