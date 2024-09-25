package com.miraijr.query_side.application.modules.product.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.miraijr.query_side.application.modules.product.models.responses.CategoryTreeViewResponse;
import com.miraijr.query_side.application.modules.product.services.CategoryService;
import com.miraijr.query_side.application.modules.product.services.CategoryTreeViewService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
  private final CategoryService CategoryService;
  private final CategoryTreeViewService categoryTreeViewService;

  @GetMapping()
  public List<CategoryTreeViewResponse> getCategoryTreeView() {
    return this.categoryTreeViewService.getCategoriesTreeView();
  }
}
