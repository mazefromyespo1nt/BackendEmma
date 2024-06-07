package com.service.users.authservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CasinorepApplication {

	private static Logger logger = LoggerFactory.getLogger(CasinorepApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CasinorepApplication.class, args);
		logger.info("Test logger");
		//logger.debug("Test logger");
		//logger.trace("Test logger");
	}
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                .allowedOrigins("*")
	                .allowedMethods("*")
	                .allowedHeaders("*");
	            }
	        };
	    }

}
