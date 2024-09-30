package com.miraijr.query_side.application.modules.product.repositories;

import com.miraijr.query_side.application.modules.product.entities.ProductElasticsearchEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductElasticsearchRepository extends ElasticsearchRepository<ProductElasticsearchEntity, Long> {
}
