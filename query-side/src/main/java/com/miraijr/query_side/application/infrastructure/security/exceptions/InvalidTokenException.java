package com.miraijr.query_side.application.infrastructure.security.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.query_side.shared.exceptions.ApplicationException;

public class InvalidTokenException extends ApplicationException {
  public InvalidTokenException() {
    super("AUTH-ERROR-0001", "Invalid token", HttpStatus.UNAUTHORIZED);
  }
}
