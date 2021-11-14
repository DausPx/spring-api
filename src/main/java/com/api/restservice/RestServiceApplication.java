package com.api.restservice;

import com.api.restservice.repository.ImageRepository;
import com.api.restservice.repository.ScoreRepository;
import com.api.restservice.repository.SightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication implements CommandLineRunner{

	@Autowired
	SightRepository sightRepository;

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	ScoreRepository scoreRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO: add test data.
		
	}

}
