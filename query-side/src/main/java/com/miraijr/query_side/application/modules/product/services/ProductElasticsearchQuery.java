package com.miraijr.query_side.application.modules.product.services;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.miraijr.query_side.application.modules.product.entities.ProductElasticsearchEntity;
import com.miraijr.query_side.application.modules.product.models.requests.SearchProductRequest;
import com.miraijr.query_side.application.modules.product.repositories.ProductElasticsearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductElasticsearchQuery {
    private ProductElasticsearchRepository productElasticsearchRepository;
    private final ElasticsearchClient elasticsearchClient;
    private static final String INDEX = "products";
    private static final List<String> SEARCH_FIELDS = Arrays.asList("name", "description");

    public List<ProductElasticsearchEntity> search(SearchProductRequest inputModel) throws Exception {
        List<ProductElasticsearchEntity> products = new ArrayList<>();
        SearchResponse<ProductElasticsearchEntity> search;

        try {
            search = this.elasticsearchClient.search(s -> s
                            .index(INDEX)
                            .from((inputModel.getPage() - 1) * inputModel.getSize())
                            .size(inputModel.getSize())
                            .query(q -> q
                                    .bool(b -> b
                                            .must(m -> m
                                                    .multiMatch(t -> t
                                                            .query(inputModel.getPrompt())
                                                            .fields(SEARCH_FIELDS)
                                                            .fuzziness("AUTO")))
                                            .filter(f -> f
                                                    .range(r -> r
                                                            .number(n -> n.field(
                                                                            "price")
                                                                    .gte(inputModel.getMinPrice().doubleValue())
                                                                    .lte(inputModel.getMaxPrice().doubleValue())))))),
                    ProductElasticsearchEntity.class);
            search.hits().hits().forEach(hit -> products.add(hit.source()));
        } catch (ElasticsearchException | IOException e) {
            throw new Exception(e.getMessage(), e.getCause());
        }

        return products;
    }
}
