package com.dwbi.dwbibackendv2.controller.requests;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AddDriverRequest {

    private String lastName;

    private String firstName;

    private String carPlates;

    private BigDecimal rating;

    private String phoneNumber;

    private String driverType;
}
