package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserInputService {

    @Autowired
    private RestTemplate restTemplate;

    public String handleUserInput(String input) {
        try {
            // Send a GET request to the Convert Time Microservice's endpoint
            String conversionResult = restTemplate.getForObject(
                    "http://127.0.0.1:8081/convertTimeToWords?time=" + input, String.class);

            return conversionResult;
        } catch (Exception e) {
            return "Error while processing input: " + e.getMessage();
        }
    }
}
