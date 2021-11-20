package com.api.restservice.repository;

import com.api.restservice.model.Rating;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    
}
