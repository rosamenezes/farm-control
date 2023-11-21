package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entities.Fertilizer;

/**
 * Fertilizer DTO.
 */
public record DtoFertilizer(
    Long id,
    String name,
    String brand,
    String composition
) {

  /**
   * Dto.
   */
  public static DtoFertilizer from(Fertilizer fertilizer) {
    return new DtoFertilizer(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition()
    );
  }

  /**
   * toFertilizer.
   */
  public Fertilizer toFertilizer() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName(name);
    fertilizer.setBrand(brand);
    fertilizer.setComposition(composition);
    return fertilizer;
  }
}