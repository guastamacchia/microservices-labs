package com.ibm.cloud.academy;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
public class ConsumerController {
    final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/", produces = "text/plain")
    public String index() {

        String url = "http://producer:8080/";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        System.out.println(response.getBody());

        return "Hello from Spring Boot! " + new java.util.Date() + " on " + hostname + "\n" 
        + " and from " + response.getBody();
    }
}