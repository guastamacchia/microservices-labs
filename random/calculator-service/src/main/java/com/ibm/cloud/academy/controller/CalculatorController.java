package com.ibm.cloud.academy.controller;

import java.util.Objects;

import com.ibm.cloud.academy.controller.bean.RandomInteger;
import com.ibm.cloud.academy.controller.bean.RandomOperator;
import com.ibm.cloud.academy.controller.bean.Solution;
import com.ibm.cloud.academy.service.NumberGeneratorService;
import com.ibm.cloud.academy.service.OpGeneratorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
	
	private static final Logger logger = LoggerFactory.getLogger( CalculatorController.class );
	final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

	private final ExpressionParser parser = new SpelExpressionParser();
	private final OpGeneratorService opGeneratorService;
	private final NumberGeneratorService numberGeneratorService;

	public CalculatorController(OpGeneratorService opGeneratorService, NumberGeneratorService numberGeneratorService) {
		this.numberGeneratorService = numberGeneratorService;
		this.opGeneratorService = opGeneratorService;
	}

	@RequestMapping
	public Solution calculate() {
		
		logger.info( "Calling services to get data" );

		RandomOperator operator = opGeneratorService.getOperator();
		RandomInteger number1 = numberGeneratorService.getNumber();
		RandomInteger number2 = numberGeneratorService.getNumber();

		String expression = number1.getValue() + " " + operator.getValue() + " " + number2.getValue();
		
		logger.info( "Parsing exp: " + expression );
		
		Expression exp = parser.parseExpression( expression );
		
		Solution solution = new Solution();

		solution.setExpression(expression);
		solution.setNumber1(number1);
		solution.setNumber2(number2);
		solution.setOperator(operator);
		solution.setValue( Objects.requireNonNull(exp.getValue()).toString() );
		solution.setHostname(hostname);
		
		return solution;
	}

}
