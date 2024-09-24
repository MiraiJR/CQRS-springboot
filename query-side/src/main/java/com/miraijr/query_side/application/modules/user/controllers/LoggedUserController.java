package com.miraijr.query_side.application.modules.user.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miraijr.query_side.application.modules.user.models.responses.UserResponse;
import com.miraijr.query_side.application.modules.user.services.LoggedUserService;
import com.miraijr.query_side.shared.annotations.interfaces.UserId;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users/me")
@AllArgsConstructor
public class LoggedUserController {
    private final LoggedUserService loggedUserService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public UserResponse getLoggedInUser(@UserId() Long userId) {
        return this.loggedUserService.getLoggedInUser(userId);
    }
}
