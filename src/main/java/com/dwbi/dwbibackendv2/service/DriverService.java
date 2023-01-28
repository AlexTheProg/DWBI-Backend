package com.dwbi.dwbibackendv2.service;

import com.dwbi.dwbibackendv2.model.Driver;
import com.dwbi.dwbibackendv2.repo.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public Set<Driver> getAllDrivers(){
        return new HashSet<>(driverRepository.findAll());
    }
}
