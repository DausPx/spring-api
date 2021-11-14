package com.api.restservice.repository;

import com.api.restservice.model.Image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    
}
