package com.dwbi.dwbibackendv2.service;

import com.dwbi.dwbibackendv2.controller.requests.LocationRequest;
import com.dwbi.dwbibackendv2.model.Location;
import com.dwbi.dwbibackendv2.repo.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(Integer id) {
        return locationRepository.findById(id).orElse(null);
    }

    public Location addLocation(LocationRequest request) {
        Location location = Location.builder()
                .locationType(request.getLocationType())
                .county(request.getCounty())
                .street(request.getStreet())
                .city(request.getCity())
                .build();
        locationRepository.save(location);
        return location;
    }

    public Location updateLocation(Integer id, LocationRequest request) {
        Location location = locationRepository.findById(id).orElse(null);

        if (location != null) {
            location = Location.builder()
                    .locationType(request.getLocationType())
                    .county(request.getCounty())
                    .street(request.getStreet())
                    .city(request.getCity())
                    .build();
            location.setId(id);
            locationRepository.save(location);
            return location;
        }
        return null;
    }

    public Location deleteLocation(Integer id) {
        Location location = locationRepository.findById(id).orElse(null);

        if (location != null) {
            locationRepository.deleteById(id);
            return location;
        }
        return null;
    }
}
