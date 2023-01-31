package com.dwbi.dwbibackendv2.repo;

import com.dwbi.dwbibackendv2.model.warehouse.CompletedAndCancelledTripsEachCity;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class WarehouseRepository {

    @PersistenceContext
    private final EntityManager entityManager;


    public List<?> getCompletedCancelledTripStats() {
        List<?> resultList =
                entityManager.createNativeQuery("""
                                SELECT status, COUNT(trip_id), CITY
                                FROM trip_dw trip, location_dw location
                                WHERE trip.LOCATION_START_ID = location.LOCATION_ID
                                GROUP BY status, CITY
                                ORDER BY COUNT(trip_id) DESC""", "TripStatsResult")
                        .getResultList();

        return resultList;
    }

}
