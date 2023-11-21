package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entities.Crop;
import java.time.LocalDate;

/**
 * Data Transfer Object for Crop.
 */
public record DtoCrop(
    Integer id,
    String name,
    Double plantedArea,
    Integer farmId,
    LocalDate plantedDate,
    LocalDate harvestDate
) {
  /**
   * Converts an entity to a DTO.
   */
  public static DtoCrop from(Crop crop) {
    return new DtoCrop(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarm().getId(),
        crop.getPlantedDate(),
        crop.getHarvestDate()
        );
  }

  /**
   * Converts this DTO to an entity.
   * reutrn the entity.
   */
  public Crop toCrop() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    crop.setPlantedDate(plantedDate);
    crop.setHarvestDate(harvestDate);
    return crop;
  }
}
