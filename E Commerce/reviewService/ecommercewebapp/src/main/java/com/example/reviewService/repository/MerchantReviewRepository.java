package com.example.reviewService.repository;

import com.example.reviewService.entity.MerchantReview;
import com.example.reviewService.entity.ProductReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantReviewRepository extends CrudRepository<MerchantReview, Long> {
    public List<MerchantReview> findByMerchantId(Long merchantId);
}
