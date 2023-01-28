package com.dwbi.dwbibackendv2.controller;

import com.dwbi.dwbibackendv2.model.Driver;
import com.dwbi.dwbibackendv2.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/oltp")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/drivers")
    public ResponseEntity<Set<Driver>>  consultOltpDrivers(){
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

}
