package com.betrybe.agrix.service;

import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.repositories.RepoCrop;
import com.betrybe.agrix.repositories.RepoFertilizer;
import com.betrybe.agrix.service.exceptions.CropNotFoundException;
import com.betrybe.agrix.service.exceptions.FertilizerNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service.
 */
@Service
public class CropService {
  private final RepoCrop repoCrop;
  private final RepoFertilizer repoFertilizer;

  @Autowired
  public CropService(RepoCrop repoCrop, RepoFertilizer repoFertilizer) {
    this.repoCrop = repoCrop;
    this.repoFertilizer = repoFertilizer;
  }

  /**
   * AssociateFertilizerToCrop.
   */
  public void fertilizerToCrop(int cropId, Long fertilizerId) {
    Crop crop = repoCrop.findById(cropId).orElseThrow(CropNotFoundException::new);
    Fertilizer fertilizer = repoFertilizer
        .findById(fertilizerId).orElseThrow(FertilizerNotFoundException::new);
    fertilizer.getCrops().add(crop);
    crop.getFertilizers().add(fertilizer);
    repoFertilizer.save(fertilizer);
    repoCrop.save(crop);
  }

  /**
   * CreateCrops.
   */
  public Crop createCrop(Crop crop) {
    return repoCrop.save(crop);
  }

  /**
   * GetAllCrops.
   */
  public List<Crop> getCrops() {
    return repoCrop.findAll();
  }

  /**
   * CropsNotFoundException.
   */
  public Crop getCropById(int id) throws CropNotFoundException {
    return repoCrop.findById(id)
        .orElseThrow(CropNotFoundException::new);
  }

  /**
   * SearchCropsByHarvestDate.
   */
  public List<Crop> searchCropsByHarvestDate(LocalDate start, LocalDate end) {
    return repoCrop.findByHarvestDateBetween(start, end);
  }
}