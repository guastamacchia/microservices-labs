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
	
	private static final Logger logger = LoggerFactory.getLogger( GeneratorController.class );
	private final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
	private static final Random rand = new Random();

	@Value("${operators}")
	String[] operators;
	
	@RequestMapping
	public ResponseEntity<RandomOperator> getOperator(){
		int index = rand.nextInt( operators.length );

		RandomOperator operator = new RandomOperator();
		operator.setValue(operators[ index ]);
		operator.setHostname(hostname);
		
		logger.info( "RandomOperator generato: " +  operator.getValue() );
		
		return new ResponseEntity<>(operator, HttpStatus.OK);
	}
}
