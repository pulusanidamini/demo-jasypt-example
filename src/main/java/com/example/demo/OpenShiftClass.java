package com.example.demo;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.vault.annotation.VaultPropertySource;


@SpringBootApplication
@VaultPropertySource("secret/sample-jasypt")
public class OpenShiftClass {
	
	private Log log = LogFactory.getLog(OpenShiftClass.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(OpenShiftClass.class, args);
		MyTest myTest = configurableApplicationContext.getBean(MyTest.class);
		myTest.testPrint();
	}


    @Value("${jasypt.encryptor.password}")
    String password;
    
    @PostConstruct
    private void postConstruct() {
    	log.info("My password is: " + password);
    }
    

@Component
class MyTest {

	    private Logger logger = LogManager.getLogger(MyTest.class);
		
	    @Value("${userdemo.name}")
	    private String username;

	    @Value("${usercity.name}")
	    private String cityname;

	    public void testPrint() {
	        logger.info("##############################");
	        logger.info("Username is --------> {}", username);
	        logger.info("Cityname is --------> {}", cityname);
	        logger.info("##############################");
	    }

	}
}