package com.betrybe.agrix.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * FarmNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class FarmNotFoundException extends RuntimeException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}