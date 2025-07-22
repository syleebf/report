package com.example.report.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailRequest {

    @NotBlank
    private String email;

}
