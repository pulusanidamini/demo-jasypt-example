package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {
	
	private Log log = LogFactory.getLog(restController.class);

	@Value("${jasypt.encryptor.password}")
	String password;

	@RequestMapping("/secret")
	public String secret() {
		return "my secret is " + password;
	}
}
