package com.api.restservice.repository;

import com.api.restservice.model.Rating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT AVG(r.rating) FROM Rating r WHERE r.sight.id = ?1")
    double getAverageRating(long sightId);
}
