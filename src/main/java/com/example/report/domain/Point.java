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
public class Point {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "email", unique = true, nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer amount = 0; // 보유 포인트

}
