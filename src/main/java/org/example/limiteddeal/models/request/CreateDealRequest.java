package org.example.limiteddeal.models.request;

import java.util.Map;

public class CreateDealRequest {
    int discount;
    Map<String, Integer> products;
    Long endTime;
    Long startTime;

    public CreateDealRequest(int discount, Map<String, Integer> products, Long endTime, Long startTime) {
        this.discount = discount;
        this.products = products;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Integer> products) {
        this.products = products;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
}
