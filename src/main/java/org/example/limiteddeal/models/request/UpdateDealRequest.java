package org.example.limiteddeal.models.request;

import org.example.limiteddeal.exception.InvalidRequest;

import java.util.Map;

public class UpdateDealRequest {

    private Integer dealId;
    private DealUpdateType  updateType;
    int discount;
    private ProductUpdate product;
    Long endTime;
    Long startTime;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public UpdateDealRequest(Integer dealId, DealUpdateType updateType, Integer discount, ProductUpdate product, Long endTime, Long startTime) {
        this.dealId = dealId;
        this.updateType = updateType;
        this.discount = discount;
        this.product = product;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public DealUpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(DealUpdateType updateType) {
        this.updateType = updateType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public ProductUpdate getProduct() {
        return product;
    }

    public void setProduct(ProductUpdate products) {
        this.product = products;
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

    public void validate() throws InvalidRequest {
        if (updateType == null){
            throw new InvalidRequest("updateType vcannot be null");
        }
        updateType.validate(this);
        // implement validations based on the update Type
    }
}
