package com.ecommerce.productService.service;

import com.ecommerce.productService.entity.Product;

public interface ProductService {
    public Product get(Long id);
    public Product save(Product product);
    public Product update(Product product);
    public void delete(Long id);
}
