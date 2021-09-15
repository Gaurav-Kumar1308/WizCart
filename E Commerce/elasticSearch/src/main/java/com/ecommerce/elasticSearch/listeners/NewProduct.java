package com.ecommerce.elasticSearch.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NewProduct {
    @KafkaListener(topics = "new_product",groupId = "product")
    public void consumeNewProduct(String message){
        System.out.println("-----Product New CONSUMED MESSAGE");
        System.out.println(message);
        System.out.println("----------------------");
    }

    @KafkaListener(topics = "update_product",groupId = "product")
    public void consumeUpdateProduct(String message){
        System.out.println("----- Product Update CONSUMED MESSAGE");
        System.out.println(message);
        System.out.println("----------------------");
    }

    @KafkaListener(topics = "new_inventory",groupId = "inventory")
    public void consumeNewInventory(String message){
        System.out.println("-----Inventory New CONSUMED MESSAGE");
        System.out.println(message);
        System.out.println("----------------------");
    }

    @KafkaListener(topics = "update_inventory",groupId = "inventory")
    public void consumeUpdateInventory(String message){
        System.out.println("-----Inventory Update CONSUMED MESSAGE");
        System.out.println(message);
        System.out.println("----------------------");
    }


    @KafkaListener(topics = "new_merchant_review",groupId = "merchant_review")
    public void consumeNewMerchantReview(String message){
        System.out.println("-----Merchant Review New CONSUMED MESSAGE");
        System.out.println(message);
        System.out.println("----------------------");
    }

    @KafkaListener(topics = "update_merchant_review",groupId = "merchant_review")
    public void consumeUpdateMerchantReview(String message){
        System.out.println("-----Merchant Review Update CONSUMED MESSAGE");
        System.out.println(message);
        System.out.println("----------------------");
    }

    @KafkaListener(topics = "new_product_review",groupId = "product_review")
    public void consumeNewProductReview(String message){
        System.out.println("-----Product Review New CONSUMED MESSAGE");
        System.out.println(message);
        System.out.println("----------------------");
    }

    @KafkaListener(topics = "update_product_review",groupId = "product_review")
    public void consumeUpdateProductReview(String message){
        System.out.println("-----Product Review Update CONSUMED MESSAGE");
        System.out.println(message);
        System.out.println("----------------------");
    }
}
