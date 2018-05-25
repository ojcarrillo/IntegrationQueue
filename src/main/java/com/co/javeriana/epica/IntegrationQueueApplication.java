package com.co.javeriana.epica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class IntegrationQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationQueueApplication.class, args);
	}
}
