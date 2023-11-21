package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.DtoCrop;
import com.betrybe.agrix.controller.dto.DtoFarm;
import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import com.betrybe.agrix.service.exceptions.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class Farm.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {
  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Gets all farms.
   * return the list of farms.
   */
  @GetMapping
  public ResponseEntity<List<DtoFarm>> getFarms() {
    List<Farm> allFarms = farmService.getFarms();
    return ResponseEntity.status(HttpStatus.OK).body(allFarms.stream().map(DtoFarm::from).toList());
  }

  /**
   * Gets and return a farm by id.
   */
  @GetMapping("/{id}")
  public ResponseEntity<DtoFarm> getFarmById(@PathVariable int id) {
    Farm farmById = farmService.getFarmById(id);
    return ResponseEntity.status(HttpStatus.OK).body(DtoFarm.from(farmById));
  }

  /**
   * Creates a new farm.
   * farmDto the farm to be created.
   * return the created farm.
   */
  @PostMapping()
  public ResponseEntity<DtoFarm> newFarm(@RequestBody DtoFarm farmDto) {
    Farm newFarm = farmService.newFarm(farmDto.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(DtoFarm.from(newFarm));
  }

  /**
   * get crops from farms.
   */
  @GetMapping("/{id}/crops")
  public ResponseEntity<List<DtoCrop>> getCropsFromFarms(@PathVariable("id") int farmId)
      throws FarmNotFoundException {
    Farm farmById = farmService.getFarmById(farmId);
    List<Crop> allCrops = farmById.getCrops();
    return ResponseEntity.status(HttpStatus.OK).body(allCrops.stream().map(DtoCrop::from).toList());
  }

  /**
   * create crop.5
   */
  @PostMapping("/{id}/crops")
  public ResponseEntity<DtoCrop> newCrop(@PathVariable("id") int id, @RequestBody DtoCrop cropDto)
      throws FarmNotFoundException {
    Crop cropById = farmService.newCrop(cropDto.toCrop(), id);
    return ResponseEntity.status(HttpStatus.CREATED).body(DtoCrop.from(cropById));
  }
}