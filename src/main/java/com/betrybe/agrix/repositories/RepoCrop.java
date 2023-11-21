package com.betrybe.agrix.repositories;

import com.betrybe.agrix.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Crop.
 */
@Repository
public interface RepoCrop extends JpaRepository<Crop, Integer> {

}
