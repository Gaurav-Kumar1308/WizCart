package com.ecommerce.productService.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Document
public class Product {

    @Id
    private Long id;
    private String productName;
//    private float price;
    private String imageURL;
    private String description;



    private Map<String,String> attributes;
    private Category category;


//    @JsonAnySetter
//    public void add(String key, String value){
//        if(null==attributes){
//            attributes = new HashMap<>();
//        }
//        attributes.put(key, value);
//    }

//    @JsonAnyGetter
//    public Map<String, String> get(){
//        return attributes;
//p
//
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
