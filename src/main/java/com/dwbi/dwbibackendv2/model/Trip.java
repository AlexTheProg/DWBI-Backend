package com.dwbi.dwbibackendv2.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "trip")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDateTime pickupTime;

    @Column(name = "DROPOFF_TIME")
    private LocalDateTime dropoffTime;

    @Column(name = "CURRENCY", length = 4)
    private String currency;

    @Lob
    @Column(name = "STATUS")
    private String status;

    @Column(name = "WAITING_FEE", precision = 15, scale = 2)
    private BigDecimal waitingFee;

    @Column(name = "CANCEL_FEE", precision = 15, scale = 2)
    private BigDecimal cancelFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCATION_START_ID")
    private Location locationStart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCATION_END_ID")
    private Location locationEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @OneToMany(mappedBy = "trip")
    private Set<Invoice> invoices = new LinkedHashSet<>();


}