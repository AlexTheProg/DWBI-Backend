package com.dwbi.dwbibackendv2.controller;

import com.dwbi.dwbibackendv2.controller.requests.AddDriverRequest;
import com.dwbi.dwbibackendv2.model.Driver;
import com.dwbi.dwbibackendv2.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/drivers/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable("id")Integer id){
        return ResponseEntity.ok(driverService.getDriverById(id));
    }

    @DeleteMapping("/drivers/{id}")
    public ResponseEntity<Driver> deleteDriverById(@PathVariable("id")Integer id){
        return ResponseEntity.ok(driverService.deleteDriverById(id));
    }

    @PostMapping("/drivers")
    public ResponseEntity<Driver> addDriver(@RequestBody AddDriverRequest request){
        return ResponseEntity.ok(driverService.saveDriver(request));
    }
}
