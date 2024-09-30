package com.miraijr.query_side.application.modules.product.services;

import com.miraijr.query_side.application.modules.product.entities.ProductElasticsearchEntity;
import com.miraijr.query_side.application.modules.product.exceptions.CanNotSearchProduct;
import com.miraijr.query_side.application.modules.product.models.requests.SearchProductRequest;
import com.miraijr.query_side.application.modules.product.models.responses.ProductResponse;
import com.miraijr.query_side.application.modules.product.models.responses.SearchProductResponse;
import com.miraijr.query_side.application.modules.product.repositories.ProductElasticsearchRepository;
import com.miraijr.query_side.shared.models.responses.SearchQueryResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchProductService {
    private final ProductElasticsearchQuery productElasticsearchQuery;

    public SearchQueryResult<SearchProductRequest, SearchProductResponse> searchProducts(SearchProductRequest inputModel) {
        inputModel.setDefaultValue();
        SearchQueryResult<SearchProductRequest, SearchProductResponse> result = new SearchQueryResult<>();
        result.setQuery(inputModel);
        List<ProductElasticsearchEntity> products;
        try {
            products = this.productElasticsearchQuery.search(inputModel);
            result.setResult(new SearchProductResponse(products.stream().map(ProductResponse::convertFromEntity).toList()));
            return result;
        } catch (Exception e) {
            throw new CanNotSearchProduct();
        }
    }
}
