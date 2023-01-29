package com.dwbi.dwbibackendv2.service;

import com.dwbi.dwbibackendv2.controller.requests.TripRequest;
import com.dwbi.dwbibackendv2.model.Trip;
import com.dwbi.dwbibackendv2.repo.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Integer id) {
        return tripRepository.findById(id).orElse(null);
    }

    public Trip deleteTrip(Integer id) {
        Trip trip = tripRepository.findById(id).orElse(null);

        if (trip != null) {
            tripRepository.deleteById(id);
            return trip;
        }
        return null;
    }

    public Trip addTrip(TripRequest request) {
        Trip trip = Trip.builder()
                .driver(request.getDriver())
                .client(request.getClient())
                .invoice(request.getInvoice())
                .currency(request.getCurrency())
                .distance(request.getDistance())
                .estimatedCost(request.getEstimatedCost())
                .dropoffTime(request.getDropoffTime())
                .pickupTime(request.getPickupTime())
                .status(request.getStatus())
                .cancelFee(request.getCancelFee())
                .locationEnd(request.getLocationEnd())
                .locationStart(request.getLocationStart())
                .waitingFee(request.getWaitingFee())
                .build();
        tripRepository.save(trip);
        return trip;
    }

    public Trip updateTrip(Integer id, TripRequest request) {
        Trip trip = tripRepository.findById(id).orElse(null);

        if (trip != null) {
            trip = Trip.builder()
                    .driver(request.getDriver())
                    .client(request.getClient())
                    .invoice(request.getInvoice())
                    .currency(request.getCurrency())
                    .distance(request.getDistance())
                    .estimatedCost(request.getEstimatedCost())
                    .dropoffTime(request.getDropoffTime())
                    .pickupTime(request.getPickupTime())
                    .status(request.getStatus())
                    .cancelFee(request.getCancelFee())
                    .locationEnd(request.getLocationEnd())
                    .locationStart(request.getLocationStart())
                    .waitingFee(request.getWaitingFee())
                    .build();
            tripRepository.save(trip);
            return trip;
        }
        return null;
    }

}
