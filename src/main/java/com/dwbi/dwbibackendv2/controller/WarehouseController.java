package com.dwbi.dwbibackendv2.controller;

import com.dwbi.dwbibackendv2.model.warehouse.CompletedAndCancelledTripsEachCity;
import com.dwbi.dwbibackendv2.repo.WarehouseRepository;
import com.dwbi.dwbibackendv2.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;

    @GetMapping("/trip-status-stats")
    public ResponseEntity<List<?>> tripStatusStats() {
        return ResponseEntity.ok(warehouseService.get());
    }

}
