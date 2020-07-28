package com.ibm.cloud.academy.controller;

import com.ibm.cloud.academy.service.ServiceA;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

	private final ServiceA service;

	public Controller(ServiceA service) {
		this.service = service;
	}

	@RequestMapping(value = "/", produces = "text/plain")
	public String indexA() {
        String call = service.callB();
		return "IBM" + " (" + hostname + ") " + call;
	}

}
