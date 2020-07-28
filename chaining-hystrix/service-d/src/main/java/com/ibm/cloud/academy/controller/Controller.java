package com.ibm.cloud.academy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

	@RequestMapping(value = "/", produces = "text/plain")
	public String indexD() {
		return "Luglio 2020" + " (" + hostname + ") ";
	}
}
