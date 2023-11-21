package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entities.Crop;

/**
 * Data Transfer Object for Crop.
 */
public record DtoCrop(Integer id, String name, Double plantedArea, Integer farmId) {
  public static DtoCrop from(Crop crop) {
    return new DtoCrop(crop.getId(), crop.getName(), crop.getPlantedArea(), crop.getFarm().getId());
  }

  /**
   * Converts this DTO to an entity.
   * reutrn the entity.
   */
  public Crop toCrop() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    return crop;
  }
}
