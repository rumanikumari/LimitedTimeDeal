package org.example.limiteddeal.models.request;

public class ProductUpdate {
    private String productId;
    private Integer newLimit;

    public ProductUpdate(String productId, Integer newLimit) {
        this.productId = productId;
        this.newLimit = newLimit;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getNewLimit() {
        return newLimit;
    }

    public void setNewLimit(Integer newLimit) {
        this.newLimit = newLimit;
    }
}
