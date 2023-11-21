package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.DtoCrop;
import com.betrybe.agrix.entities.Crop;
import com.betrybe.agrix.service.CropService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}