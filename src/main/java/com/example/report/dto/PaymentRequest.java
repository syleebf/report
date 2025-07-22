package com.example.report.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.N;

@Getter
@Setter
public class PaymentRequest {

    @NotBlank
    private String paymentKey;

    @NotBlank
    private String orderId;

    @NotBlank
    private String amount;

}
