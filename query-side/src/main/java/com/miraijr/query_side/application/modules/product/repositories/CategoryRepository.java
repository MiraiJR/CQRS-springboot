package com.miraijr.query_side.application.modules.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miraijr.query_side.application.modules.product.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
