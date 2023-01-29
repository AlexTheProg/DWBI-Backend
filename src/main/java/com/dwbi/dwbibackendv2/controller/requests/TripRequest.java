package com.dwbi.dwbibackendv2.controller.requests;

import com.dwbi.dwbibackendv2.model.Client;
import com.dwbi.dwbibackendv2.model.Driver;
import com.dwbi.dwbibackendv2.model.Invoice;
import com.dwbi.dwbibackendv2.model.Location;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
public class TripRequest {

    private BigDecimal distance;

    private BigDecimal estimatedCost;

    private Instant pickupTime;

    private Instant dropoffTime;

    private String currency;

    private String status;

    private BigDecimal waitingFee;

    private BigDecimal cancelFee;

    private Location locationStart;

    private Location locationEnd;

    private Driver driver;

    private Client client;

    private Invoice invoice;
}
