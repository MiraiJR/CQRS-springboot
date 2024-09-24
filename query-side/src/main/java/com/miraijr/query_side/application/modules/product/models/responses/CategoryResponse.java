package com.miraijr.query_side.application.modules.product.models.responses;

import java.util.List;

import com.miraijr.query_side.application.modules.product.entities.CategoryEntity;

import lombok.Builder;

@Builder
public record CategoryResponse(
        Long id,
        String name,
        String slug,
        List<CategoryResponse> sub_categories) {
    public static CategoryResponse convertFromEntity(CategoryEntity entity) {
        var builder = new CategoryResponseBuilder();
        builder.id(entity.getId())
                .name(entity.getName())
                .slug(entity.getSlug());

        if (entity.getSubCategories() != null) {
            builder.sub_categories(
                    entity.getSubCategories().stream().map(CategoryResponse::convertFromEntity)
                            .toList());
        }

        return builder.build();
    }
}
