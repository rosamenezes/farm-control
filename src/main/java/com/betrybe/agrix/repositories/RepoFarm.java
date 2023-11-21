package com.betrybe.agrix.repositories;

import com.betrybe.agrix.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Farm.
 */
@Repository
public interface RepoFarm extends JpaRepository<Farm, Integer> {

}