package com.example.demo;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.annotation.VaultPropertySource;


@SpringBootApplication
@VaultPropertySource("secret/sample-jasypt")
public class OpenShiftClass {
	
	private Log log = LogFactory.getLog(OpenShiftClass.class);

	public static void main(String[] args) {
		SpringApplication.run(OpenShiftClass.class, args);
	}


    @Value("${jasypt.encryptor.password}")
    String password;
    
    @PostConstruct
    private void postConstruct() {
    	log.info("My password is: " + password);
    }
    
}