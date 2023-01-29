package com.dwbi.dwbibackendv2.controller;

import com.dwbi.dwbibackendv2.controller.requests.LocationRequest;
import com.dwbi.dwbibackendv2.model.Location;
import com.dwbi.dwbibackendv2.service.LocationService;
import com.electronwill.nightconfig.core.conversion.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/oltp")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id")Integer id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> addLocation(@RequestBody LocationRequest request) {
        return ResponseEntity.ok(locationService.addLocation(request));
    }

    @PutMapping("/locations/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable("id")Integer id,
                                                   @RequestBody LocationRequest request) {
        return ResponseEntity.ok(locationService.updateLocation(id, request));
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable("id")Integer id) {
        return ResponseEntity.ok(locationService.deleteLocation(id));
    }
}
