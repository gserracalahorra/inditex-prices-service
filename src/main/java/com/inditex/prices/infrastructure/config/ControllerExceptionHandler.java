package com.inditex.prices.infrastructure.config;

import com.inditex.prices.application.exception.ResourceNotFoundException;
import com.inditex.prices.infrastructure.rest.dto.ErrorMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorMessageDto> handleResourceNotFoundException(
      ResourceNotFoundException ex) {
    var errorMessageDto = new ErrorMessageDto();
    errorMessageDto.code(HttpStatus.NOT_FOUND.value());
    errorMessageDto.message(ex.getMessage());
    return new ResponseEntity<>(errorMessageDto, HttpStatus.NOT_FOUND);
  }

}
