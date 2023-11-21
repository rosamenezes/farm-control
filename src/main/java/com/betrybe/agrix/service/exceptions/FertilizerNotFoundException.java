package com.betrybe.agrix.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * fertilizer exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FertilizerNotFoundException extends RuntimeException {
  /**
   * Fertilizer not found exception.
   */
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}