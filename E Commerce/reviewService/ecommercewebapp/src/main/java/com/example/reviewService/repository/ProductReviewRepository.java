package com.example.reviewService.repository;

import com.example.reviewService.entity.ProductReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {
    List<ProductReview> findByproductId(Long productId);
}
