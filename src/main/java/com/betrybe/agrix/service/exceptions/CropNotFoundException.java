package com.betrybe.agrix.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * CropNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CropNotFoundException extends RuntimeException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
