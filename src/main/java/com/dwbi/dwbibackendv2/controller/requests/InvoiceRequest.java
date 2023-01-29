package com.dwbi.dwbibackendv2.controller.requests;

import com.dwbi.dwbibackendv2.model.Trip;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class InvoiceRequest {

    private BigDecimal amountToPay;

    private String status;

    private BigDecimal tips;

    private String paymentType;

    private Trip trip;
}
