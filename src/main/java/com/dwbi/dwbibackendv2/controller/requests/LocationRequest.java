package com.dwbi.dwbibackendv2.controller.requests;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Getter;

@Getter
public class LocationRequest {

    private String locationType;

    private String county;

    private String city;

    private String street;
}
