package com.betrybe.agrix.service;

import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.repositories.RepoFertilizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fertilizer service.
 */
@Service
public class FertilizerService {
  @Autowired
  private RepoFertilizer repoFertilizer;


  public Fertilizer createFertilizer(Fertilizer fertilizer) {
    return repoFertilizer.save(fertilizer);
  }
}
