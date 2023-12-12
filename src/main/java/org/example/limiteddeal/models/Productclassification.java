package org.example.limiteddeal.models;

import org.example.limiteddeal.exception.ProductAlreadyPresent;

import java.util.HashMap;
import java.util.Map;

public class Productclassification {
    Map<String, ProductEntity> products; // productId to entitymap


    public Productclassification(Map<String, ProductEntity> products) {
        this.products = products;
    }
    public Productclassification() {
        this.products = new HashMap<>();
    }

    public void addProduct(String productId, Integer limit){
        ProductEntity productEntity = new ProductEntity(productId, limit);
        products.put(productId, productEntity);
    }

    public void updateProduct(String productId, Integer limit) {
        if(hasProduct(productId)){
            products.get(productId).setInventoryLimit(limit);
        }
        addProduct(productId, limit);
    }

    public boolean hasProduct(String productId){
        return products.containsKey(productId);
    }

    public Integer getLimit(String productId) {
        return products.get(productId).getInventoryLimit();
        // TODO: add validations
    }
}
