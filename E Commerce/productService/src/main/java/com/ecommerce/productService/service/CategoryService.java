package com.ecommerce.productService.service;

import com.ecommerce.productService.entity.Category;

public interface CategoryService {
    public Category get(Long id);
    public Category save(Category category);
    public Category update(Category category);
    public void delete(Long id);
}
