package com.example.reviewService.dto;

public class ProductReviewAverage {
    private Long productID;
    private Double rating;

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
