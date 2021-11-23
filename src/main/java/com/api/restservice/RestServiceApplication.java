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
public class RestServiceApplication implements CommandLineRunner {

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
		String[] urlList = { "https://thumbs.dreamstime.com/b/rialto-bridge-famous-sight-venice-no-people-133884865.jpg",
		 "https://media.istockphoto.com/photos/the-pyramids-of-giza-famous-sight-near-cairo-egypt-picture-id1263635189", 
		 "https://llandscapes-10674.kxcdn.com/wp-content/uploads/2019/07/lighting.jpg", 
		 "https://clickstay.s3-eu-west-1.amazonaws.com/images/blog/post-images/800x400/ebeb419ce87fbe7562b364b20de33144_5c7fc98c8e24c.jpg", 
		 "https://img.theculturetrip.com/wp-content/uploads/2017/09/httpscommons-wikimedia-orgwikifile3athe_island_of_st-_stephen-jpg.jpg" };
		String[] names = { "Morbi elementum ultricies quam", "Vestibulum semper", "Pellentesque fringilla magna nec",
				"Proin pellentesque", "Phasellus tincidunt" };
		String[] descriptions = {
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ipsum lectus, posuere vel quam eget, dignissim posuere nibh. Quisque ut sollicitudin justo, nec maximus diam.",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque porta pharetra facilisis. Nullam eu nisl auctor, dapibus nisi id, bibendum justo. Vivamus turpis dolor, dignissim.",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi efficitur enim in felis vehicula, eget tempor odio volutpat. Nunc ac enim et ipsum feugiat scelerisque.",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean suscipit suscipit risus, quis consequat risus molestie id. Sed feugiat hendrerit quam. Nullam interdum, nisi sed.",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin maximus mollis purus ac malesuada. Aliquam eu fermentum ligula. Vivamus tincidunt nisi ac neque porta luctus." };
		String[] relevances = { "znamenito", "veoma znamenito", "nezaobilazno" };
		String[] lans = { "32.429066", "31.806484", "34.650826", "31.463181", "43.018600" };
		String[] lons = { "-85.715233", "-85.968628", "-86.088501", "-85.647202", "-88.259773" };

		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			Sight sight = new Sight(names[i], descriptions[i], true, relevances[random.nextInt(0, 3)], lans[i], lons[i]);

			Image image = new Image(urlList[i]);

			sight.addImage(image);

			Sight createdSight = sightRepository.save(sight);
			
			for (int j = 0; j < 5; j++) {
				Rating rating = new Rating(random.nextInt(1, 6), createdSight);
				ratingRepository.save(rating);
			}
		}

	}

}
