package com.Myles.votingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class VotingSystem {

	public static void main(String[] args) {
		SpringApplication.run(VotingSystem.class, args);
	}

}
