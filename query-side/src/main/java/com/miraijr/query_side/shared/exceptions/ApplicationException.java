package com.miraijr.query_side.shared.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
  private final String errorCode;
  private final HttpStatus statusCode;

  public ApplicationException(String errorCode, String message, HttpStatus statusCode) {
    super(message);
    this.errorCode = errorCode;
    this.statusCode = statusCode;
  }
}
