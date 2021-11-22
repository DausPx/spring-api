package com.api.restservice;

import java.util.Random;

import com.api.restservice.model.Image;
import com.api.restservice.model.Rating;
import com.api.restservice.model.Sight;
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
	RatingRepository ratingRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Image image1 = new Image("http.nesto.com");
		Image image2 = new Image("http.nesto2.com");
		Image image3 = new Image("http.nesto3.com");
		
		Sight sight1 = new Sight("ime1", "opis koji treba da je vezan za ime 1", true, "znamenito", "11.11.11", "22.22.22");

		sight1.addImage(image1);
		sight1.addImage(image2);
		sight1.addImage(image3);

		Sight createdSight = sightRepository.save(sight1);

		Random random = new Random(); 

		for(int i = 0; i<10; i++){
			Rating rating = new Rating(random.nextInt(1, 6),createdSight);
			ratingRepository.save(rating);
		}


	}

}
