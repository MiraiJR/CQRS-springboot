package com.miraijr.query_side.application.modules.product.models.responses;

import java.util.ArrayList;
import java.util.List;

import com.miraijr.query_side.application.modules.product.entities.CategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryTreeViewResponse {
    private Long id;
    private String name;
    private String slug;
    private List<CategoryTreeViewResponse> sub_categories;

    public static CategoryTreeViewResponse convertFromEntity(CategoryEntity entity) {
        var builder = new CategoryTreeViewResponseBuilder();
        builder.id(entity.getId())
                .name(entity.getName())
                .slug(entity.getSlug())
                .sub_categories(new ArrayList<>());

        return builder.build();
    }

    public void addSubCategory(CategoryTreeViewResponse category) {
        if (this.sub_categories == null) {
            this.sub_categories = new ArrayList<>();
        }

        this.sub_categories.add(category);
    }
}
