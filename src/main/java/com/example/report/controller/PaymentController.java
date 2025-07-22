package com.example.report.controller;

import com.example.report.dto.ApiResponse;
import com.example.report.dto.PaymentCardRequest;
import com.example.report.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<ApiResponse> registerCard(@RequestBody @Valid PaymentCardRequest request) {
        paymentService.registerCard(request);

        ApiResponse response = new ApiResponse(HttpStatus.OK.value(), "카드 등록 성공");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}