package org.example.limiteddeal.service;

import org.example.limiteddeal.exception.EntityNotFound;
import org.example.limiteddeal.exception.InvalidClaim;
import org.example.limiteddeal.exception.InvalidDealUpdate;
import org.example.limiteddeal.exception.ProductAlreadyPresent;
import org.example.limiteddeal.models.Deal;
import org.example.limiteddeal.models.Productclassification;
import org.example.limiteddeal.repositories.DealRepository;

import java.util.List;
import java.util.Map;


public class DealService {

    private static int IDIncrement = 1;

    private DealRepository dealRepository;

    public DealService(DealRepository dealRepository) {
        dealRepository = dealRepository;
    }

    public Deal createDeal(int discount, Map<String, Integer> products, Long endTime, Long startTime) {
        int id = IDIncrement + 1;
        IDIncrement = IDIncrement + 1;
        Productclassification productclassification = new Productclassification();
        for(Map.Entry<String, Integer> product : products.entrySet()){
            productclassification.addProduct(product.getKey(), product.getValue());
        }
        Deal deal = new Deal(id, discount, productclassification, endTime, startTime);
        return deal;
    }

    public void updateDealEndTime(Integer dealId, Long endTime) throws EntityNotFound, InvalidDealUpdate {
        Deal deal = dealRepository.getDeal(dealId);
        if (endTime < System.currentTimeMillis())
            throw new InvalidDealUpdate("Endtime cannot be lesser than the current time");
        deal.setEndTime(endTime);
    }

    public void updateDealStartTime(Integer dealId, Long startTime) throws InvalidDealUpdate, EntityNotFound {
        Deal deal = dealRepository.getDeal(dealId);
        if (startTime > deal.getEndTime())
            throw new InvalidDealUpdate("starttime cannot be after endtime");
        deal.setStartTime(startTime);
    }

    public void updateProduct(Integer dealId, String productId, Integer limit) throws EntityNotFound {
        Deal deal = dealRepository.getDeal(dealId);
        deal.updateProduct(productId, limit);
    }

    // Assuming the product will get updated with latest values

    public void updateDiscount(Integer dealId, Integer discount) throws EntityNotFound {
        Deal deal = dealRepository.getDeal(dealId);
        deal.setDiscount(discount);
    }

    public void claimDeal(Integer dealId, String productId) throws EntityNotFound, InvalidClaim {
        Deal deal = dealRepository.getDeal(dealId);
        deal.claimDeal(productId);
    }

    // currently not dealing with the Customer and its validations, assuming customer is valid and we are claiming the deal
}
