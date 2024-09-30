package com.miraijr.query_side.application.modules.product.models.responses;

import java.math.BigDecimal;

import com.miraijr.query_side.application.modules.product.entities.ProductElasticsearchEntity;
import com.miraijr.query_side.application.modules.product.entities.ProductEntity;

import lombok.Builder;

@Builder
public record ProductResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Long stock,
        String slug) {
    public static ProductResponse convertFromEntity(ProductEntity entity) {
        var builder = new ProductResponseBuilder();
        builder.id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .slug(entity.getSlug())
                .price(entity.getPrice())
                .stock(entity.getStock());

        return builder.build();
    }

    public static ProductResponse convertFromEntity(ProductElasticsearchEntity entity) {
        var builder = new ProductResponseBuilder();
        builder.id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .slug(entity.getSlug())
                .price(BigDecimal.valueOf(entity.getPrice()))
                .stock(0L);

        return builder.build();
    }
}
