package com.plukash.teamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TeamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamerApplication.class, args);
	}

}
