package com.betrybe.agrix.service;

import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Farm;
import com.betrybe.agrix.repositories.RepoFarm;
import com.betrybe.agrix.service.exceptions.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Farm Service.
 */
@Service
public class FarmService {
  private final RepoFarm repoFarm;
  private final CropService cropService;

  @Autowired
  public FarmService(RepoFarm repoFarm, CropService cropService) {
    this.repoFarm = repoFarm;
    this.cropService = cropService;
  }

  /**
   * GetAllFarms.
   */
  public List<Farm> getFarms() {
    return repoFarm.findAll();
  }

  /**
   * GetFarmById.
   */
  public Farm getFarmById(int id) throws FarmNotFoundException {
    return repoFarm.findById(id).orElseThrow(FarmNotFoundException::new);
  }

  /**
   * CreateFarm.
   */
  public Farm newFarm(Farm farm) {
    return repoFarm.save(farm);
  }

  /**
   * CreateCrop.
   */
  public Crop newCrop(Crop crop, int farmId) throws FarmNotFoundException {
    Farm farm = getFarmById(farmId);
    crop.setFarm(farm);
    return cropService.createCrop(crop);
  }
}