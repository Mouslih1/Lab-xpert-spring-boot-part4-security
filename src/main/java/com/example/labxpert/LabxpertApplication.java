package com.example.labxpert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LabxpertApplication{

	public static void main(String[] args) {
		SpringApplication.run(LabxpertApplication.class, args);
	}

}
