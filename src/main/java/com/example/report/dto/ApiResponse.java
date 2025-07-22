package com.example.report.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

    private int StatusCode;
    private String StatusMessage;

    public ApiResponse (int statusCode, String message) {
        this.StatusCode = statusCode;
        this.StatusMessage = message;
    }
}
