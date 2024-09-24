package com.miraijr.query_side.application.infrastructure.security.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.query_side.shared.exceptions.ApplicationException;

public class ExpiredTokenException extends ApplicationException {

  public ExpiredTokenException() {
    super("AUTH-ERROR-0002", "Expired token", HttpStatus.UNAUTHORIZED);
  }
}
