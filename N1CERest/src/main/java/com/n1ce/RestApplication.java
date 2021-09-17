package com.n1ce;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.n1ce")
@ServletComponentScan("com.n1ce.utils.security") 
public class RestApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(RestApplication.class);

	@PostConstruct
    public void postConstruct() {
       logger.info("postConstruct...");          
    }
	
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

    @PreDestroy
    public static void preShutdown() {
    	logger.debug("preShutdown..."); 
    }
    
}
