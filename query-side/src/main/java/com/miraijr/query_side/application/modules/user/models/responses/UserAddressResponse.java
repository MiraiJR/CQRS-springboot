package com.miraijr.query_side.application.modules.user.models.responses;

import com.miraijr.query_side.application.modules.user.entities.UserAddressEntity;

import lombok.Builder;

@Builder
public record UserAddressResponse(
        Long id,
        String province,
        String district,
        String ward,
        String home_address,
        Integer type) {
    public static UserAddressResponse convertFromEntity(UserAddressEntity entity) {
        return new UserAddressResponse(entity.getId(), entity.getProvince(), entity.getDistrict(), entity.getWard(),
                entity.getHomeAddress(), entity.getType());
    }
}
