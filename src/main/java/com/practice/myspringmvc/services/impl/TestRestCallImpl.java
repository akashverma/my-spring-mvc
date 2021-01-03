package com.practice.myspringmvc.services.impl;

import com.practice.myspringmvc.repositories.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class TestRestCallImpl {
    public void callme() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "https://apisitintgateway.adib.co.ae/adibint/otp_audit/getotpevent?xUniqueId=2100001969";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        headers.set("X-COM-LOCATION", "USA");
        headers.set("Authorization", "Bearer eyJraWQiOiJ1eTlRSFNuUFNyTGxxckJ0am54dWYxb09ET1JJU0ktYmp6NW9rekQzMjY4IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzZXJ2aWNlYSIsInNjb3BlIjoibXlzY29wZSIsImlzcyI6Imh0dHBzOi8vY2lhbXNpdC5hZGliLmFlIiwiYXVkIjoidXJuOmxpYmVydHkiLCJpYXQiOjE2MDQ2NjU2MTAsImV4cCI6MTYwNDY2OTIxMCwiZ3JvdXBzIjpbXSwiYXV0aGVudGljYXRpb25UeXBlcyI6W119.bwZofdQvuSmc1et9D1c945Ga6sbAS2T-lRc05LUXxgEmMJpfd2jFMEoUgj2Y5IF3l9r5tXXGMRrr4eDnqtRK94Cz9vvGOhl4eMvZLZreRzvdImHUHtGQQYPGOjTvOxkIfwbTn0hWOqYiJD7B8PDDoBfAFmAJQ71GCvBR4MGJirQ");

        HttpEntity<Employee> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
        System.out.println(result);
    }
}
