package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.DtoFertilizer;
import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.service.FertilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {
  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * Create.
   */
  @PostMapping
  public ResponseEntity<DtoFertilizer> createFertilizer(@RequestBody DtoFertilizer fertilizerDto) {
    Fertilizer createdFertilizer = fertilizerService.createFertilizer(fertilizerDto.toFertilizer());
    return ResponseEntity.status(HttpStatus.CREATED).body(DtoFertilizer.from(createdFertilizer));
  }
}
