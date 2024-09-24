package com.miraijr.query_side.application.modules.product.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.miraijr.query_side.application.modules.product.entities.CategoryEntity;
import com.miraijr.query_side.application.modules.product.models.responses.CategoryTreeViewResponse;
import com.miraijr.query_side.application.modules.product.repositories.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryTreeViewService {
  private final CategoryRepository categoryRepository;

  public List<CategoryTreeViewResponse> getCategoriesTreeView() {
    List<CategoryEntity> categories = this.categoryRepository.findAll();

    return this.buildCategoryTree(categories);
  }

  private List<CategoryTreeViewResponse> buildCategoryTree(List<CategoryEntity> categories) {
    Map<Long, CategoryTreeViewResponse> categoryMap = new HashMap<>();
    List<CategoryTreeViewResponse> rootCategories = new ArrayList<>();

    for (CategoryEntity category : categories) {
      categoryMap.put(category.getId(), CategoryTreeViewResponse.convertFromEntity(category));
    }

    for (CategoryEntity category : categories) {
      if (category.getParent() == null) {
        rootCategories.add(categoryMap.get(category.getId()));
        continue;
      }

      CategoryTreeViewResponse parentCategory = categoryMap.get(category.getParent().getId());
      if (parentCategory != null) {
        parentCategory.addSubCategory(CategoryTreeViewResponse.convertFromEntity(category));
      }
    }

    return rootCategories;
  }
}
