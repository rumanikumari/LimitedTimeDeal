package org.example.limiteddeal.models;

public class ProductEntity {
    private String productId;
    private int inventoryLimit;

    public ProductEntity(String productId, int inventoryLimit) {
        this.productId = productId;
        this.inventoryLimit = inventoryLimit;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getInventoryLimit() {
        return inventoryLimit;
    }

    public void setInventoryLimit(int inventoryLimit) {
        this.inventoryLimit = inventoryLimit;
    }
}
