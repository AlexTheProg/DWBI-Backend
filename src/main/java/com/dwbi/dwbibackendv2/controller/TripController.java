package com.dwbi.dwbibackendv2.controller;

import com.dwbi.dwbibackendv2.controller.requests.TripRequest;
import com.dwbi.dwbibackendv2.model.Trip;
import com.dwbi.dwbibackendv2.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/oltp")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping("/trips")
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @GetMapping("/trips/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable("id")Integer id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @PostMapping("/trips")
    public ResponseEntity<Trip> addTrip(@RequestBody TripRequest request) {
        return ResponseEntity.ok(tripService.addTrip(request));
    }

    @PutMapping("/trips/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable("id")Integer id,
                                           @RequestBody TripRequest request) {
        return ResponseEntity.ok(tripService.updateTrip(id, request));
    }

    @DeleteMapping("/trips/{id}")
    public ResponseEntity<Trip> deleteTrip(@PathVariable("id")Integer id) {
        return ResponseEntity.ok(tripService.deleteTrip(id));
    }
}
