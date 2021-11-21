package com.api.restservice;

import com.api.restservice.repository.ImageRepository;
import com.api.restservice.repository.RatingRepository;
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
	RatingRepository scoreRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO: add test data.
		
	}

}
