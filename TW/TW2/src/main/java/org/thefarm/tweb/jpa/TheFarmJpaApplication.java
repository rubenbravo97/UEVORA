package org.thefarm.tweb.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheFarmJpaApplication {

    @Autowired
    private UserRepository repository;
    
	public static void main(String[] args) {
		SpringApplication.run(TheFarmJpaApplication.class, args);
	}

}
