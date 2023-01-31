package com.dwbi.dwbibackendv2.service;

import com.dwbi.dwbibackendv2.model.warehouse.CompletedAndCancelledTripsEachCity;
import com.dwbi.dwbibackendv2.repo.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<CompletedAndCancelledTripsEachCity> get() {
        return warehouseRepository.getCompletedCancelledTripStats();
    }
}
