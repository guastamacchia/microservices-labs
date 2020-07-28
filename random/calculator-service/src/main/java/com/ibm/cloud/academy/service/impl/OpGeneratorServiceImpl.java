package com.ibm.cloud.academy.service.impl;

import com.ibm.cloud.academy.controller.bean.RandomOperator;
import com.ibm.cloud.academy.service.OpGeneratorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class OpGeneratorServiceImpl implements OpGeneratorService {

	@Value("${opgeneratorUrl}")
	String opgeneratorUrl;

	private final RestTemplate rest;

	public OpGeneratorServiceImpl(RestTemplate rest) {
		this.rest = rest;
	}

	@HystrixCommand( fallbackMethod = "defaultOperator" )
	public RandomOperator getOperator() {
		return Objects.requireNonNull(rest.getForEntity(opgeneratorUrl, RandomOperator.class).getBody());
	}

	public RandomOperator defaultOperator() {
		RandomOperator ro = new RandomOperator();
		ro.setHostname("fallback");
		ro.setValue("+");
		return ro;
	}
}