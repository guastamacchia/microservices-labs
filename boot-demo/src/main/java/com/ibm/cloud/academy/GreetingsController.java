package com.ibm.cloud.academy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
   final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

   @RequestMapping(value = "/hello", produces = "text/plain")
   public String sayHello() {
      return "Hello from Spring Boot! " + new java.util.Date() + " on " + hostname + "\n";
   }
   
   @RequestMapping(value = "/bonjour", produces = "text/plain")
   public String sayBonjour() {
      return "Bonjour de Spring Boot! " + new java.util.Date() + " sur " + hostname + "\n";
   }
   
   @RequestMapping(value = "/hola", produces = "text/plain")
   public String sayHola() {
      return "Hola de Spring Boot! " + new java.util.Date() + " en " + hostname + "\n";
   }
}