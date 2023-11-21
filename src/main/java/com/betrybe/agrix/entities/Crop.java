package com.betrybe.agrix.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 * Entidade Crop.
 */
@Entity
@Table(name = "crops")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;
  private String name;
  private Double plantedArea;
  private LocalDate plantedDate;
  private LocalDate harvestDate;

  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Farm getFarm() {
    return farm;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }
}
