package com.miraijr.query_side.application.modules.user.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.query_side.shared.exceptions.ApplicationException;

public class UserNotFound extends ApplicationException {
    public UserNotFound() {
        super("USER-ERROR-0001", "User not found", HttpStatus.NOT_FOUND);
    }
}
