package com.example.inventoryService.dto;

public class InventoryDto {

    private long id;
    private long productId;
    private long merchantId;
    private int merchantPrice;
    private int quantity;
    private String pinCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

    public int getMerchantPrice() {
        return merchantPrice;
    }

    public void setMerchantPrice(int merchantPrice) {
        this.merchantPrice = merchantPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}

