package com.miraijr.query_side.application.modules.user.models.responses;

import java.util.List;

import com.miraijr.query_side.application.modules.user.entities.UserEntity;

import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String full_name,
        String email,
        String phone_number,
        Integer gender,
        List<UserAddressResponse> addresses) {
    public static UserResponse convertFromEntity(UserEntity entity) {
        var builder = new UserResponseBuilder();
        builder.id(entity.getId());
        builder.full_name(entity.getFullName());
        builder.email(entity.getEmail());
        builder.phone_number(entity.getPhoneNumber());
        builder.gender(entity.getGender());

        if (entity.getAddresses() != null) {
            builder.addresses(
                    entity.getAddresses().stream().map(UserAddressResponse::convertFromEntity).toList());
        }

        return builder.build();
    }
}
