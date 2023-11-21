package com.betrybe.agrix.repositories;

import com.betrybe.agrix.entities.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository for Crop.
 */

public interface RepoCrop extends JpaRepository<Crop, Integer> {
  List<Crop> findByHarvestDateBetween(LocalDate start, LocalDate end);
}
