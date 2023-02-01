package com.dwbi.dwbibackendv2.controller;

import com.dwbi.dwbibackendv2.controller.requests.AddDriverRequest;
import com.dwbi.dwbibackendv2.model.Driver;
import com.dwbi.dwbibackendv2.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/oltp")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>>  consultOltpDrivers(){
        return ResponseEntity.ok(driverService.getAllDrivers().stream().sorted(Comparator.comparingInt(Driver::getId)).collect(Collectors.toList()));
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

    @PutMapping("/drivers/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable("id")Integer id,
                                               @RequestBody AddDriverRequest updateDriver){
        return ResponseEntity.ok(driverService.updateDriver(id, updateDriver));
    }

}
