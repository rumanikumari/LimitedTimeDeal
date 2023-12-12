package org.example.limiteddeal.service;

import org.example.limiteddeal.exception.DealCreationFailed;
import org.example.limiteddeal.exception.InvalidRequest;
import org.example.limiteddeal.exception.ProductAlreadyPresent;
import org.example.limiteddeal.models.Deal;
import org.example.limiteddeal.models.request.CreateDealRequest;
import org.example.limiteddeal.models.request.UpdateDealRequest;

import java.util.Map;

public class SellerPlatform {

    DealService dealService;

    public SellerPlatform(DealService dealService) {
        this.dealService = dealService;
    }

    public Deal createDeal(CreateDealRequest request) throws DealCreationFailed {
        try {
            // perform Some request validations for mandatory request data
            return dealService.createDeal(request.getDiscount(), request.getProducts(), request.getEndTime(), request.getStartTime());
        } catch (Exception e) {
            throw new DealCreationFailed("Deal creation failed due to : " + e.getMessage());
        }
    }

    public void updateDeal(UpdateDealRequest request) throws DealCreationFailed, InvalidRequest {
        try {
            request.validate();
            request.getUpdateType().performUpdate(dealService, request);
// TODO: this should be converted to a factory pattern based on the updateType. i.e factory.getUpdateProcesor(updateType).update()
        } catch (Exception e) {
            throw new DealCreationFailed("Deal creation failed due to : " + e.getMessage());
        }
    }
}
