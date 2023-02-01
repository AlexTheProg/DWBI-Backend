package com.dwbi.dwbibackendv2.service;

import com.dwbi.dwbibackendv2.controller.requests.AddDriverRequest;
import com.dwbi.dwbibackendv2.model.Driver;
import com.dwbi.dwbibackendv2.repo.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public Set<Driver> getAllDrivers(){
        return new HashSet<>(driverRepository.findAll());
    }

    public Driver getDriverById(Integer id){
        return driverRepository.findById(id).orElse(null);
    }

    public Driver deleteDriverById(Integer id){
        Optional<Driver> driver = driverRepository.findById(id);

        if(driver.isPresent()){
            driverRepository.deleteById(id);
            return driver.get();
        }
        return null;
    }

    public Driver saveDriver(AddDriverRequest request) {

        Driver driver = Driver.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .rating(request.getRating())
                .driverType(request.getDriverType())
                .phoneNumber(request.getPhoneNumber())
                .carPlates(request.getCarPlates())
                .build();

        return driverRepository.save(driver);
    }

    public Driver updateDriver(Integer id, AddDriverRequest updateDriver){
        Driver driver = driverRepository.findById(id).orElse(null);

        if (driver != null){
            driver = Driver.builder()
                    .firstName(updateDriver.getFirstName())
                    .lastName(updateDriver.getLastName())
                    .rating(updateDriver.getRating())
                    .driverType(updateDriver.getDriverType())
                    .phoneNumber(updateDriver.getPhoneNumber())
                    .carPlates(updateDriver.getCarPlates())
                    .build();
            driver.setId(id);
            driverRepository.save(driver);
            return driver;
        }
        return null;
    }
}
