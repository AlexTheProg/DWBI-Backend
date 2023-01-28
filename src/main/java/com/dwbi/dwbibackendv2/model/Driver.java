package com.dwbi.dwbibackendv2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "driver")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "RATING", length = 2)
    private String rating;

    @Column(name = "PHONE_NUMBER", length = 15)
    private String phoneNumber;

    @Lob
    @Column(name = "DRIVER_TYPE")
    private String driverType;


}