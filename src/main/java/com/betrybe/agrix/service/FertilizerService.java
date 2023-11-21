package com.betrybe.agrix.service;

import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.repositories.RepoFertilizer;
import com.betrybe.agrix.service.exceptions.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Fertilizer service.
 */
@Service
public class FertilizerService {
  @Autowired
  private RepoFertilizer repoFertilizer;

  /**
   * Create Fertilizer.
   */
  public Fertilizer createFertilizer(Fertilizer fertilizer) {
    return repoFertilizer.save(fertilizer);
  }

  /**
   * Get All Fertilizers.
   */
  public List<Fertilizer> getAll() {
    return repoFertilizer.findAll();
  }

  /**
   * Get Fertilizer By Id.
   */
  public Fertilizer getFertilizerById(Long id) {
    return repoFertilizer.findById(id).orElseThrow(FertilizerNotFoundException::new);
  }
}
