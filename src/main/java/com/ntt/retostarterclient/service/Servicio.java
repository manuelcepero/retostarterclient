/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntt.retostarterclient.service;

import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manuel
 */

public class Servicio {

    Logger logger = LoggerFactory.getLogger(Service.class);

    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8888/";
    String urlFinal = "actuator/status/";

    public String setToOpen() {
        String fooResourceUrl = url + urlFinal;
        ResponseEntity<String> response = restTemplate.postForEntity(URI.create(fooResourceUrl), "open", String.class);
        logger.info("Estado: open");
        return response.getBody();
    }

    public String setToHalfOpen() {
        String fooResourceUrl = url + urlFinal;
        ResponseEntity<String> response = restTemplate.postForEntity(URI.create(fooResourceUrl), "half-open", String.class);
        logger.info("Estado: half-open");
        return response.getBody();
    }

    public String setToClose() {
        String fooResourceUrl = url + urlFinal;
        ResponseEntity<String> response = restTemplate.postForEntity(URI.create(fooResourceUrl), "close", String.class);
        logger.info("Estado: close");
        return response.getBody();
    }
}
