package com.api.restservice.repository;

import java.util.List;

import com.api.restservice.model.Sight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SightRepository extends JpaRepository<Sight, Long> {
    List<Sight> findByNameContainingAndActiveIs(String name, boolean active);
    List<Sight> findByNameContainingAndRelevanceIsAndActiveIs(String name, String relevance, boolean active);
    List<Sight> findByRelevanceAndActiveIs(String relevance, boolean active);
    List<Sight> findByActiveIs(boolean active);
}
