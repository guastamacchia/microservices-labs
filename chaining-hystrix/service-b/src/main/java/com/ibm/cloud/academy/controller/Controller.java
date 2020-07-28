package com.ibm.cloud.academy.controller;

import com.ibm.cloud.academy.service.ServiceB;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

	private final ServiceB service;

	public Controller(ServiceB service) {
		this.service = service;
	}

	@RequestMapping(value = "/", produces = "text/plain")
	public String indexB() {
        String call = service.callC();
		return "Cloud" + " (" + hostname + ") " + call;
	}

}
