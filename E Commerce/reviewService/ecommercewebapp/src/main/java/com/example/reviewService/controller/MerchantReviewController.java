package com.example.reviewService.controller;

import com.example.reviewService.dto.MerchantReviewAverage;
import com.example.reviewService.dto.MerchantReviewDto;
import com.example.reviewService.entity.MerchantReview;
import com.example.reviewService.entity.ProductReview;
import com.example.reviewService.service.MerchantReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController   //This is one additional behaviour(aspect)
@RequestMapping(value = "review/merchant_review/db")
public class MerchantReviewController {

    @Autowired
    private MerchantReviewService merchantReviewService;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/display")
    public String display(){
        return "Merchant Review Display";
    }

    @GetMapping(value = "/{id}")
    public MerchantReviewDto get(@PathVariable(name = "id") Long id) {
        MerchantReview merchantReview = merchantReviewService.get(id);
        if (merchantReview == null) {
            return null;
        }
        MerchantReviewDto merchantReviewDto = new MerchantReviewDto();
        BeanUtils.copyProperties(merchantReview, merchantReviewDto);
        return merchantReviewDto;
    }


    @PostMapping
    public MerchantReviewDto save(@RequestBody MerchantReview merchantReview) {
        MerchantReviewDto merchantReviewDto = new MerchantReviewDto();

        BeanUtils.copyProperties(merchantReview, merchantReviewDto);
        MerchantReview savedMerchantReview = merchantReviewService.save(merchantReview);

        Double average = merchantReviewService.findByMerchantId(merchantReview.getMerchantId()).stream().mapToDouble(MerchantReview::getMerchantRating).average().orElse(0);
        MerchantReviewAverage merchantReviewAverage = new MerchantReviewAverage();

        merchantReviewAverage.setMerchantID(merchantReview.getMerchantId());
        merchantReviewAverage.setRating(average);

        System.out.println("Ratingggg "+merchantReviewAverage.getRating());
        kafkaTemplate.send("new_merchant_review",merchantReviewAverage);
        MerchantReviewDto savedMerchantReviewDto = new MerchantReviewDto();
        BeanUtils.copyProperties(savedMerchantReview, savedMerchantReviewDto);
        return savedMerchantReviewDto;
    }

    @PutMapping
    public MerchantReviewDto update(@RequestBody MerchantReviewDto merchantReviewDto) {

        MerchantReview merchantReview = new MerchantReview();
        BeanUtils.copyProperties(merchantReviewDto, merchantReview);

        MerchantReview updatedMerchantReview = merchantReviewService.save(merchantReview);
        kafkaTemplate.send("update_merchant_review",updatedMerchantReview);

        MerchantReviewDto updatedMerchantReviewDto = new MerchantReviewDto();
        BeanUtils.copyProperties(updatedMerchantReview, updatedMerchantReviewDto);
        return updatedMerchantReviewDto;

    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        merchantReviewService.delete(id);

    }
}
