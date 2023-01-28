package com.dwbi.dwbibackendv2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "client")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @Column(name = "CLIENT_ID", nullable = false)
    private Integer id;

    @Column(name = "FIRST_NAME", length = 25)
    private String firstName;

    @Column(name = "LAST_NAME", length = 25)
    private String lastName;

    @Column(name = "RATING", length = 2)
    private String rating;

    @Column(name = "PHONE_NUMBER", length = 15)
    private String phoneNumber;

    @Column(name = "USERNAME", length = 15)
    private String username;

    @Column(name = "PASSWORD", length = 20)
    private String password;

    @Column(name = "EMAIL", length = 25)
    private String email;


}