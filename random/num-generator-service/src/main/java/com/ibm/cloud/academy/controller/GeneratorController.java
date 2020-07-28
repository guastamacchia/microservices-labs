package com.ibm.cloud.academy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class GeneratorController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorController.class);
	private final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
	private final Random rand = new Random();
	
	@Value("${maxint}")
	Integer maxint;
	
	@RequestMapping
	public ResponseEntity<RandomInteger> getNumber(){
		int value = rand.nextInt( maxint ) + 1;

		RandomInteger number = new RandomInteger();
		number.setHostname(hostname);
		number.setValue(value);
		
		LOGGER.info( "RandomInteger generato: " +  number.getValue() );
		
		return new ResponseEntity<>(number, HttpStatus.OK);
	}
}
