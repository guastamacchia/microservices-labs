package com.ibm.cloud.academy;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
public class PersonaController {

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/persona", produces = "text/plain")
    public String persona() {

        String url = "http://nome:8080/nome";
        ResponseEntity<String> nomeRes = restTemplate.getForEntity(url, String.class);

        url = "http://cognome:8080/cognome";
        ResponseEntity<String> cognomeRes = restTemplate.getForEntity(url, String.class);

        return nomeRes.getBody() + " " + cognomeRes.getBody();
    }
}