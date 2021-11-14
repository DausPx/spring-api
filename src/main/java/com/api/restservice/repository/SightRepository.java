package com.api.restservice.repository;

import com.api.restservice.model.Sight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SightRepository extends JpaRepository<Sight, Long> {
    
}
