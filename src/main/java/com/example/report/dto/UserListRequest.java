package com.example.report.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListRequest {

    @NotBlank
    private String keyword;

    @NotBlank
    private boolean asc = true;

    @NotBlank
    private int page;

}
