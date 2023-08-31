package com.kn.heartbeat.integration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class SoapClient {

    public String soapHealthCheck() {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8033/actuator/health";
        ResponseEntity<HealthStatus> response
                = restTemplate.getForEntity(fooResourceUrl, HealthStatus.class);
        return response.getBody().getStatus();
    }

}
