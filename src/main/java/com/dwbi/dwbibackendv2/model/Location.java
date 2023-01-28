package com.dwbi.dwbibackendv2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "location")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @Column(name = "LOCATION_ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "LOCATION_TYPE")
    private String locationType;

    @Column(name = "COUNTY", length = 25)
    private String county;

    @Column(name = "CITY", length = 25)
    private String city;

    @Column(name = "STREET", length = 50)
    private String street;

}