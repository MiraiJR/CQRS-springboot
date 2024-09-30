package com.miraijr.query_side.application.modules.product.controllers;

import com.miraijr.query_side.application.modules.product.models.requests.SearchProductRequest;
import com.miraijr.query_side.application.modules.product.models.responses.SearchProductResponse;
import com.miraijr.query_side.application.modules.product.services.SearchProductService;
import com.miraijr.query_side.shared.models.responses.SearchQueryResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/search")
@AllArgsConstructor
public class SearchProductController {
    private final SearchProductService searchProductService;

    @GetMapping
    public SearchQueryResult<SearchProductRequest, SearchProductResponse> searchProducts(
            @Valid @ModelAttribute SearchProductRequest inputData) {
        return this.searchProductService.searchProducts(inputData);
    }
}
