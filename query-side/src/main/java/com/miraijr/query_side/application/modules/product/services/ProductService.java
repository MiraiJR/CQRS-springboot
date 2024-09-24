package com.miraijr.query_side.application.modules.product.services;

import org.springframework.stereotype.Service;

import com.miraijr.query_side.application.modules.product.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
}
