package com.betrybe.agrix.controller;

import com.betrybe.agrix.service.exceptions.CropNotFoundException;
import com.betrybe.agrix.service.exceptions.FarmNotFoundException;
import com.betrybe.agrix.service.exceptions.FertilizerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller NOT_FOUND.
 */
@ControllerAdvice
public class ControllerNotFound {
  /**
   * Handle not found.
   */
  @ExceptionHandler({
      FarmNotFoundException.class, CropNotFoundException.class, FertilizerNotFoundException.class
  })
  public ResponseEntity<String> handleNotFound(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }
}
