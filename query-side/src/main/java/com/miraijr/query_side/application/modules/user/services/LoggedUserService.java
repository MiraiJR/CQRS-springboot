package com.miraijr.query_side.application.modules.user.services;

import org.springframework.stereotype.Service;
import com.miraijr.query_side.application.modules.user.exceptions.UserNotFound;
import com.miraijr.query_side.application.modules.user.models.responses.UserResponse;
import com.miraijr.query_side.application.modules.user.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoggedUserService {
    private final UserRepository userRepository;

    public UserResponse getLoggedInUser(Long userId) {
        var matchedUser = this.userRepository.findById(userId);

        if (matchedUser.isEmpty()) {
            throw new UserNotFound();
        }

        return UserResponse.convertFromEntity(matchedUser.get());
    }
}
