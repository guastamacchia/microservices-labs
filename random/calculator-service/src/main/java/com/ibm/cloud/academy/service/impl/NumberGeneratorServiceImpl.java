package com.ibm.cloud.academy.service.impl;

import com.ibm.cloud.academy.controller.bean.RandomInteger;
import com.ibm.cloud.academy.service.NumberGeneratorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class NumberGeneratorServiceImpl implements NumberGeneratorService {

	@Value("${numbergeneratorUrl}")
	String numbergeneratorUrl;

	private final RestTemplate rest;

	public NumberGeneratorServiceImpl(RestTemplate rest) {
		this.rest = rest;
	}

	@HystrixCommand( fallbackMethod = "defaultNumber" )
	public RandomInteger getNumber() {
		return Objects.requireNonNull(rest.getForEntity(numbergeneratorUrl, RandomInteger.class).getBody());
	}

	public RandomInteger defaultNumber() {
		RandomInteger ri = new RandomInteger();
		ri.setHostname("fallback");
		ri.setValue(1000);
		return ri;
	}
}