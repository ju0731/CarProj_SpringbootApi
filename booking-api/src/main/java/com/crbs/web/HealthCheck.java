package com.crbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

	private static final Logger logger = LoggerFactory.getLogger(HealthCheck.class);

	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public HttpStatus healthCheck() {
		logger.info("Keep Health Check");
		return HttpStatus.OK;
	}
	
}
