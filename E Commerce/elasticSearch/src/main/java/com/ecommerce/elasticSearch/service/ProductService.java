package com.ecommerce.elasticSearch.service;

import com.ecommerce.elasticSearch.document.Product;
import com.ecommerce.elasticSearch.search.SearchDTO;

import java.util.List;

public interface ProductService {
    public Product get(Long id);
    public Product save(Product product);
    public Product update(Product product);
    public void delete(Long id);
    public List<Product> search(SearchDTO searchDTO);
    public void saveAll(List<Product> productList);
    public List<Product> findByMerchantId(Long merchantId);
}
