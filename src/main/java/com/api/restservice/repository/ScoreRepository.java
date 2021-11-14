package com.api.restservice.repository;

import com.api.restservice.model.Score;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    
}
