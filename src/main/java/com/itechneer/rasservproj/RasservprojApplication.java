package com.itechneer.rasservproj;

import com.itechneer.rasservproj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RasservprojApplication {

	@Autowired
	UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(RasservprojApplication.class, args);
	}

}
