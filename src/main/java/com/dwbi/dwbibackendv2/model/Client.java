package com.dwbi.dwbibackendv2.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "client")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID", nullable = false)
    private Integer id;

    @Column(name = "FIRST_NAME", length = 25)
    private String firstName;

    @Column(name = "LAST_NAME", length = 25)
    private String lastName;

    @Column(name = "RATING", precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(name = "PHONE_NUMBER", length = 15)
    private String phoneNumber;

    @Column(name = "USERNAME", length = 15)
    private String username;

    @Column(name = "PASSWORD", length = 20)
    private String password;

    @Column(name = "EMAIL", length = 25)
    private String email;


}