package com.dwbi.dwbibackendv2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "trip")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRIP_ID", nullable = false)
    private Integer id;

    @Column(name = "DISTANCE", precision = 4, scale = 2)
    private BigDecimal distance;

    @Column(name = "ESTIMATED_COST", precision = 15, scale = 2)
    private BigDecimal estimatedCost;

    @Column(name = "PICKUP_TIME")
    private Instant pickupTime;

    @Column(name = "DROPOFF_TIME")
    private Instant dropoffTime;

    @Column(name = "CURRENCY", length = 4)
    private String currency;

    @Lob
    @Column(name = "status")
    private String status;

    @Column(name = "WAITING_FEE", precision = 15, scale = 2)
    private BigDecimal waitingFee;

    @Column(name = "CANCEL_FEE", precision = 15, scale = 2)
    private BigDecimal cancelFee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_START_ID")
    private Location locationStart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_END_ID")
    private Location locationEnd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @OneToOne(mappedBy = "trip", fetch = FetchType.EAGER)
    @JsonBackReference
    private Invoice invoice;

}