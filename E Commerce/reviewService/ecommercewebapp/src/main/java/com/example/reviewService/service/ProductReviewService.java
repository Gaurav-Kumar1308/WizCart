package com.example.reviewService.service;

import com.example.reviewService.entity.ProductReview;

import java.util.List;

public interface ProductReviewService {
    public ProductReview get(Long id);
    public ProductReview save(ProductReview productReview);
    public ProductReview update(ProductReview productReview);
    public void delete(Long id);
    public List<ProductReview> findByproductId(Long productId);
}
