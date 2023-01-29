package com.dwbi.dwbibackendv2.controller.requests;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ClientRequest {
    private String firstName;

    private String lastName;

    private BigDecimal rating;

    private String phoneNumber;

    private String username;

    private String password;

    private String email;
}
