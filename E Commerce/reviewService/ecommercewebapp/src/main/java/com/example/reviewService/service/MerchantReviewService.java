package com.example.reviewService.service;

import com.example.reviewService.entity.MerchantReview;

import java.util.List;

public interface MerchantReviewService {

    public MerchantReview get(Long id);
    public MerchantReview save(MerchantReview merchantReview);
    public MerchantReview update(MerchantReview merchantReview);
    public void delete(Long id);
    public List<MerchantReview> findByMerchantId(Long merchantId);
}
