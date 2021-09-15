package com.example.reviewService.service.impl;

import com.example.reviewService.entity.ProductReview;
import com.example.reviewService.repository.ProductReviewRepository;
import com.example.reviewService.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

    @Autowired
    ProductReviewRepository productReviewRepository;

    @Override
    public ProductReview get(Long id) {
        return productReviewRepository.findById(id).get() ;
    }

    @Override
    public ProductReview save(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    @Override
    public ProductReview update(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void delete(Long id) {
        productReviewRepository.deleteById(id);
    }

    @Override
    public List<ProductReview> findByproductId(Long productId){
        return productReviewRepository.findByproductId(productId);
    }
    
}
