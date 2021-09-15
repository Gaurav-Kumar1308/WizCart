package com.example.reviewService.controller;

import com.example.reviewService.dto.ProductReviewAverage;
import com.example.reviewService.dto.ProductReviewDto;
import com.example.reviewService.entity.ProductReview;
import com.example.reviewService.service.ProductReviewService;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController   //This is one additional behaviour(aspect)
@RequestMapping(value = "review/product_review/db")
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/display")
    public String display(){
        return "Product Review Display";
    }

    @GetMapping(value = "/{id}")
    public ProductReviewDto get(@PathVariable(name = "id") Long id) {
        ProductReview productReview = productReviewService.get(id);
        if (productReview == null) {
            return null;
        }
        ProductReviewDto productReviewDto = new ProductReviewDto();
        BeanUtils.copyProperties(productReview, productReviewDto);
        return productReviewDto;
    }


    @PostMapping
    public ProductReviewDto save(@RequestBody ProductReview productReview) {
        ProductReviewDto productReviewDto = new ProductReviewDto();
        BeanUtils.copyProperties(productReview, productReviewDto);


        ProductReview savedProductReview = productReviewService.save(productReview);

        Double average = productReviewService.findByproductId(productReview.getProductId()).stream().mapToDouble(ProductReview::getProductRating).average().orElse(0);


        ProductReviewAverage productReviewAverage = new ProductReviewAverage();
        productReviewAverage.setProductID(productReview.getProductId());
        productReviewAverage.setRating(average);
        kafkaTemplate.send("new_product_review",productReviewAverage);

        System.out.println(productReviewAverage);

        ProductReviewDto savedProductReviewDto = new ProductReviewDto();
        BeanUtils.copyProperties(savedProductReview, savedProductReviewDto);
        return savedProductReviewDto;
    }

    @PutMapping
    public ProductReviewDto update(@RequestBody ProductReviewDto productReviewDto) {

        ProductReview productReview = new ProductReview();
        BeanUtils.copyProperties(productReviewDto, productReview);

        ProductReview updatedProductReview = productReviewService.save(productReview);
        kafkaTemplate.send("update_product_review",productReview);

        ProductReviewDto updatedProductReviewDto = new ProductReviewDto();
        BeanUtils.copyProperties(updatedProductReview, updatedProductReviewDto);
        return updatedProductReviewDto;

    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        productReviewService.delete(id);
    }
}
