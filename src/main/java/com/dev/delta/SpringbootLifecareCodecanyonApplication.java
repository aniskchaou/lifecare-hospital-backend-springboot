package com.dev.delta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dev.delta.dto.ExpenseDTO;


@ComponentScan({ "com.dev.delta.security","com.dev.delta.controllers","com.dev.delta.services", "com.dev.delta.dto" }) // to scan repository files
@EntityScan("com.dev.delta.entities")
@EnableJpaRepositories("com.dev.delta.repositories")
@SpringBootApplication
public class SpringbootLifecareCodecanyonApplication implements CommandLineRunner {

	@Autowired
	ExpenseDTO expenseDTO;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootLifecareCodecanyonApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		expenseDTO.populate();
		
	}

}
