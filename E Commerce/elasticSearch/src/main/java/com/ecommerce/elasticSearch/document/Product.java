package com.ecommerce.elasticSearch.document;

import com.ecommerce.elasticSearch.helper.Indices;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Map;

@Document(indexName = Indices.PRODUCT_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Product {

    @Id
    @Field(type = FieldType.Keyword)
    private Long productId;

    @Field(type = FieldType.Keyword)
    private Long merchantId;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String imageURL;

    @Field(type = FieldType.Text)
    private String productName;

    @Field(type = FieldType.Keyword)
    private float price;

    @Field(type = FieldType.Object)
    private Category category;

    private String pinCode;

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    private int quantity;

    private float rating;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Field(type = FieldType.Object)
    private Map<String,String> attributes;

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Map<String, String> getAttributes() {
        return attributes;
    }

    //    @Id
//    @Field(type = FieldType.Keyword)
//    private Long id;
//
//    @Field(type = FieldType.Text)
//    private String name;
//
//    @Field(type = FieldType.Integer)
//    private float price;
//
////    @Field(type = FieldType.Keyword)
//

//
////    @Field(type = FieldType.Keyword)
//
//    @Field(type = FieldType.Object)
//    private Category category;
//
////    @Field(type = FieldType.Keyword)
////    @Field(type = FieldType.Object)
////    private List<Version> versionList;
//

//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public float getPrice() {
//        return price;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
//
//    public Map<String, String> getAttributes() {
//        return attributes;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
}
