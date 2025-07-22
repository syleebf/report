package com.example.report.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentCardRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String cardNumber;

    @NotBlank
    private String cardExpirationYear;

    @NotBlank
    private String cardExpirationMonth;

    @NotBlank
    private String cardPassword;

    @NotBlank
    private String customerIdentityNumber;

}
