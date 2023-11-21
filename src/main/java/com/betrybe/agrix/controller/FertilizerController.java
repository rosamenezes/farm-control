package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.DtoFertilizer;
import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.service.FertilizerService;
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

  /**
   * AllFertilizers.
   */
  @GetMapping
  public ResponseEntity<List<DtoFertilizer>> getAllFertilizers() {
    List<Fertilizer> fertilizers = fertilizerService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(fertilizers.stream()
        .map(DtoFertilizer::from).toList());
  }

  /**
   * FindFertilizerById.
   */
  @GetMapping("/{id}")
  public ResponseEntity<DtoFertilizer> findFertilizerById(@PathVariable Long id) {
    Fertilizer fertilizer = fertilizerService.getFertilizerById(id);
    return ResponseEntity.status(HttpStatus.OK).body(DtoFertilizer.from(fertilizer));
  }
}
