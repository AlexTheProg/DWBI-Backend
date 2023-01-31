package com.dwbi.dwbibackendv2.model.warehouse;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@SqlResultSetMapping(name = "TripStatsResult", classes = {
        @ConstructorResult(targetClass = CompletedAndCancelledTripsEachCity.class,
                columns = {
                        @ColumnResult(name = "status"),
                        @ColumnResult(name = "count(trip_id)"),
                        @ColumnResult(name = "city")
                })
})
@AllArgsConstructor
@NoArgsConstructor
public class CompletedAndCancelledTripsEachCity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String status;
    private Integer tripCount;
    private String city;


}
