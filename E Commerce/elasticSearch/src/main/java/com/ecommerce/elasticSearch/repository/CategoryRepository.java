package com.ecommerce.elasticSearch.repository;

import com.ecommerce.elasticSearch.document.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ElasticsearchRepository<Category,Long> {
}
