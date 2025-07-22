package com.example.report.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Payment {

    @Id @GeneratedValue
    private Long id;

    private String orderId;

    private String paymentKey;

    private Integer amount;

    private String status; // PENDING, DONE, FAILED 등

    @ManyToOne
    private User user;

    private LocalDateTime createdAt;
}
