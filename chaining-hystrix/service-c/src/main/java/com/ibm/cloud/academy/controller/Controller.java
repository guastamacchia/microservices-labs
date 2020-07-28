package com.ibm.cloud.academy.controller;

import com.ibm.cloud.academy.service.ServiceC;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

	private final ServiceC service;

	public Controller(ServiceC service) {
		this.service = service;
	}

	@RequestMapping(value = "/", produces = "text/plain")
	public String indexC() {
        String call = service.callD();
		return "Academy" + " (" + hostname + ") " + call;
	}

}
