package com.miraijr.query_side.application.modules.product.services;

import org.springframework.stereotype.Service;

import com.miraijr.query_side.application.modules.product.repositories.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

}
