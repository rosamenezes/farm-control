package com.betrybe.agrix.repositories;

import com.betrybe.agrix.entities.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Crop.
 */
@Repository
public interface RepoCrop extends JpaRepository<Crop, Integer> {
  List<Crop> getCropsByHarvestDate(LocalDate start, LocalDate end);
}
