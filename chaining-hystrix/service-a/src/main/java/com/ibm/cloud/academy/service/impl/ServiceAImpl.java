package com.ibm.cloud.academy.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class ServiceAImpl implements com.ibm.cloud.academy.service.ServiceA {

	@Value("${serviceUrl}")
	String serviceUrl;

	private final RestTemplate rest;

	public ServiceAImpl(RestTemplate rest) {
		this.rest = rest;
	}

	@HystrixCommand( fallbackMethod = "defaultCall" )
	public String callA() {
		return Objects.requireNonNull(rest.getForEntity(serviceUrl, String.class).getBody());
	}

	public String defaultCall() {
		return "Cloud Academy Luglio 2020 (fallback-service-a)";
	}
}