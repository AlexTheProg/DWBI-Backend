package com.dwbi.dwbibackendv2.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "driver")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @Column(name = "DRIVER_ID", nullable = false)
    private Integer id;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "CAR_PLATES", length = 10)
    private String carPlates;

    @Column(name = "RATING", precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(name = "PHONE_NUMBER", length = 15)
    private String phoneNumber;

    @Lob
    @Column(name = "driver_type")
    private String driverType;

}