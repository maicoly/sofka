package com.test.sofka.AccountMovements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EntityScan(basePackages = "com.test.sofka.AccountMovements.model.entity")
@EnableAsync
public class AccountMovementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountMovementApplication.class, args);
	}

}
