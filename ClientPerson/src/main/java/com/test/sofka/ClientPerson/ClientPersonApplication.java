package com.test.sofka.ClientPerson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EntityScan(basePackages = "com.test.sofka.ClientPerson.model.entity")
@EnableAsync
public class ClientPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientPersonApplication.class, args);
	}

}
