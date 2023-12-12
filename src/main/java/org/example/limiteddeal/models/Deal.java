package org.example.limiteddeal.models;

import org.example.limiteddeal.exception.EntityNotFound;
import org.example.limiteddeal.exception.InvalidClaim;

import java.util.Map;

public class Deal {

    private int id;
    private int discount;
    private Productclassification productclassification;

    private Map<String, Integer> claimedProducts;
    private Long endTime;
    private Long startTime;

    private static Long DEFAULT_END_TIME_DELAY = 7200000L; // 2Hr

    public Deal(int id, int discount, Productclassification productclassification, Long endTime, Long startTime) {
        this.id = id;
        this.discount = discount;
        this.productclassification = productclassification;
        if(startTime == null){
            startTime = System.currentTimeMillis();
        }
        if(endTime == null){
            endTime = startTime + DEFAULT_END_TIME_DELAY;
        }
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Productclassification getProductclassification() {
        return productclassification;
    }

    public void setProductclassification(Productclassification productclassification) {
        this.productclassification = productclassification;
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

    public void updateProduct(String productId, Integer limit) {
        productclassification.updateProduct(productId, limit);
    }

    public Boolean isLive(){
        return startTime <= System.currentTimeMillis() &&  System.currentTimeMillis()<= endTime;
    }

    public Boolean isExpired(){
        return System.currentTimeMillis() > endTime;
    }

    public void claimDeal(String productId) throws InvalidClaim {
        if(!productclassification.hasProduct(productId)){
            throw new InvalidClaim("Product id is not part of the Deal, invalid Claim");
        }
        if(hasRemainingClaims(productId)){
            if(claimedProducts.containsKey(productId)){
                claimedProducts.put(productId, claimedProducts.get(productId) + 1);
            }
            else{
                claimedProducts.put(productId, 1);
            }
        } else{
            throw new InvalidClaim("No remaining claims");
        }
    }

    private boolean hasRemainingClaims(String productId) {
        Integer claimedSoFar = 0;
        if (claimedProducts.containsKey(productId)){
            claimedSoFar = claimedProducts.get(productId);
        }
        Integer remainingClaims = productclassification.getLimit(productId) - claimedSoFar;
        return remainingClaims > 0;
    }
}
