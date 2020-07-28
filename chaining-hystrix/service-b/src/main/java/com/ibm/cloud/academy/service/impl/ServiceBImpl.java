package com.ibm.cloud.academy.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class ServiceBImpl implements com.ibm.cloud.academy.service.ServiceB {

	@Value("${serviceUrl}")
	String serviceUrl;

	private final RestTemplate rest;

	public ServiceBImpl(RestTemplate rest) {
		this.rest = rest;
	}

	@HystrixCommand( fallbackMethod = "defaultCall" )
	public String callB() {
		return Objects.requireNonNull(rest.getForEntity(serviceUrl, String.class).getBody());
	}

	public String defaultCall() {
		return "Academy Luglio 2020 (fallback-service-b)";
	}
}