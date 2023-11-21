package com.betrybe.agrix.service;

import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.repositories.RepoCrop;
import com.betrybe.agrix.service.exceptions.CropNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service.
 */
@Service
public class CropService {
  private final RepoCrop repoCrop;

  @Autowired
  public CropService(RepoCrop repoCrop) {
    this.repoCrop = repoCrop;
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
}