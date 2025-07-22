package com.example.report.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String cardExpirationYear;

    @Column(nullable = false)
    private String cardExpirationMonth;

    @Column(nullable = false)
    private String cardPassword;

    @Column(nullable = false)
    private String customerIdentityNumber;

    @ManyToOne
    private User user;

}
