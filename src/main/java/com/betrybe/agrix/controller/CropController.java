package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.DtoCrop;
import com.betrybe.agrix.controller.dto.DtoFertilizer;
import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.entities.Fertilizer;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.exceptions.CropNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * GetAllCrops.
   */
  @GetMapping
  public ResponseEntity<List<DtoCrop>> getCrops() {
    List<Crop> crops = cropService.getCrops();
    return ResponseEntity.status(HttpStatus.OK).body(crops.stream().map(DtoCrop::from).toList());
  }

  /**
   * get crop by id.
   */
  @GetMapping("/{id}")
  public ResponseEntity<DtoCrop> getCropById(@PathVariable int id) {
    Crop cropById = cropService.getCropById(id);
    return ResponseEntity.status(HttpStatus.OK).body(DtoCrop.from(cropById));
  }

  /**
   * get fertilizers from crops.
   */
  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<List<DtoFertilizer>> getFertilizersFromCrops(@PathVariable int cropId)
      throws CropNotFoundException {
    Crop crop = cropService.getCropById(cropId);
    List<Fertilizer> fertilizer = crop.getFertilizers();
    return ResponseEntity.status(HttpStatus.OK).body(fertilizer.stream()
        .map(DtoFertilizer::from).toList());
  }

  /**
   * find crops by harvest date between.
   */
  @GetMapping("/search")
  public ResponseEntity<List<DtoCrop>> searchCropsByHarvestDate(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end
  ) {
    List<Crop> crops = cropService.searchCropsByHarvestDate(start, end);
    return ResponseEntity.status(HttpStatus.OK).body(crops.stream().map(DtoCrop::from).toList());
  }

  /**
   * create crop.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> associateFertilizerToCrop(
      @PathVariable int cropId, @PathVariable Long fertilizerId
  ) {
    cropService
        .fertilizerToCrop(cropId, fertilizerId);
    return ResponseEntity
        .status(HttpStatus.CREATED).body("Fertilizante e plantação associados com sucesso!");
  }
}