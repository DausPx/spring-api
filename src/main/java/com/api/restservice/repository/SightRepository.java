package com.api.restservice.repository;

import java.util.List;

import com.api.restservice.model.Sight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SightRepository extends JpaRepository<Sight, Long> {
    List<Sight> findByNameContaining(String name);
    List<Sight> findByNameContainingAndRelevanceIs(String name, String relevance);
    List<Sight> findByRelevance(String relevance);
}
