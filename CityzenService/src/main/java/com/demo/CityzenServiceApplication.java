package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CityzenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityzenServiceApplication.class, args);
	}

}
