package com.example.reviewService.service.impl;

import com.example.reviewService.entity.MerchantReview;
import com.example.reviewService.repository.MerchantReviewRepository;
import com.example.reviewService.service.MerchantReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MerchantReviewServiceImpl implements MerchantReviewService {

    @Autowired
    MerchantReviewRepository merchantReviewRepository;

    @Override
    public MerchantReview get(Long id) {
        return merchantReviewRepository.findById(id).get() ;
    }

    @Override
    public MerchantReview save(MerchantReview merchantReview) {
        return merchantReviewRepository.save(merchantReview);
    }

    @Override
    public MerchantReview update(MerchantReview merchantReview) {
        return merchantReviewRepository.save(merchantReview);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void delete(Long id) {
        merchantReviewRepository.deleteById(id);
    }

    @Override
    public List<MerchantReview> findByMerchantId(Long merchantId){
        return merchantReviewRepository.findByMerchantId(merchantId);
    }
    
}
