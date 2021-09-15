package com.ecommerce.elasticSearch.repository;

import com.ecommerce.elasticSearch.document.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product,Long> {
    public List<Product> findByMerchantId(Long merchantId);
}
