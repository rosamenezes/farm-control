package com.betrybe.agrix.service;

import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.repositories.RepoFertilizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
