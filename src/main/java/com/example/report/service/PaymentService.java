package com.example.report.service;

import com.example.report.domain.Card;
import com.example.report.dto.PaymentCardRequest;
import com.example.report.repository.CardRepository;
import com.example.report.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CardRepository cardRepository;

    public void registerCard(PaymentCardRequest request) {
        Card card = new Card();
        card.setCardNumber(request.getCardNumber());
        card.setCardPassword(request.getCardPassword());
        card.setCardExpirationMonth(request.getCardExpirationMonth());
        card.setCardExpirationYear(request.getCardExpirationYear());
        card.setCustomerIdentityNumber(request.getCustomerIdentityNumber());
        card.setEmail(request.getEmail());
        cardRepository.save(card);
    }

    public void registerCardToss(PaymentCardRequest request) throws IOException {

        String widgetSecretKey = "test_sk_Z1aOwX7K8m76pweXbQ5WVyQxzvNP";
        String credentials = Base64.getEncoder().encodeToString((widgetSecretKey + ":").getBytes(StandardCharsets.UTF_8));
        String authorizations = "Basic " + credentials;

        URL url = new URL("https://api.tosspayments.com/v1/billing/authorizations/card");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", authorizations);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // JSON 바디 생성
        String json = new ObjectMapper().writeValueAsString(request);

        // 요청 전송
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(json.getBytes(StandardCharsets.UTF_8));
        }

        // 응답 코드
        int code = connection.getResponseCode();
        boolean isSuccess = code == 200;
    }
}
