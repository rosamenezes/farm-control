package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entities.Farm;

/**
 * Data Transfer Object for Farm.
 */
public record DtoFarm(Integer id, String name, Double size) {
  public static DtoFarm from(Farm farm) {
    return new DtoFarm(farm.getId(), farm.getName(), farm.getSize());
  }

  /**
   * Converts this DTO to an entity.
   * return the entity.
   */
  public Farm toFarm() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}
