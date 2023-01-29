package com.dwbi.dwbibackendv2.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_ID", nullable = false)
    private Integer id;

    @Column(name = "AMOUNT_TO_PAY", precision = 15, scale = 2)
    private BigDecimal amountToPay;

    @Lob
    @Column(name = "STATUS")
    private String status;

    @Column(name = "TIPS", precision = 15, scale = 2)
    private BigDecimal tips;

    @Lob
    @Column(name = "PAYMENT_TYPE")
    private String paymentType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

}