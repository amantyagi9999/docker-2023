package com.docker.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/")
public class HelloController {

	private static Logger logger = LogManager.getLogger(HelloController.class);
	
	@Autowired
	com.docker.service.InstanceInformationService instanceInformationService;

	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String welcome() {
		logger.debug("Hello test log...");
		return "Welcome to Azure Docker API  !";
	}

	@GetMapping("/welcome/{user}")
	public String welcome(@PathVariable(value="user") String user) {
		return "Welcome, "+ user + " on Docker Azure App";
	}
	
	@GetMapping("/pods")
	public String helloWorld() {
		return "Hello World " + " V3 " + instanceInformationService.retrieveInstanceInfo();
	}

	
}
