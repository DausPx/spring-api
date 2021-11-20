package com.api.restservice.controller;

import java.util.List;

import com.api.restservice.model.Rating;
import com.api.restservice.model.Sight;
import com.api.restservice.repository.RatingRepository;
import com.api.restservice.repository.SightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    SightRepository sightRepository;

    @GetMapping("rating")
    public ResponseEntity<List<Rating>> getRatingByID(@RequestParam long sightId){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    @PostMapping("rating")
    public ResponseEntity<Rating> setRating(@RequestParam int rating, @RequestParam Long sightId) {
        boolean sightExist = sightRepository.existsById(sightId);

        if(sightExist){
            Sight sight = sightRepository.getById(sightId);
            Rating createdRating = new Rating(rating, sight);

            return new ResponseEntity<>(createdRating, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
