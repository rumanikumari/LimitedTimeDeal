package org.example.limiteddeal.service;

import org.example.limiteddeal.exception.DealClaimFailure;
import org.example.limiteddeal.exception.EntityNotFound;
import org.example.limiteddeal.exception.InvalidClaim;

public class CustomerPlatform {

    private DealService dealService;

    public CustomerPlatform(DealService dealService) {
        this.dealService = dealService;
    }

    public void claimDeal(Integer dealId, String productId) throws DealClaimFailure {
        try {
            dealService.claimDeal(dealId, productId);
        } catch (Exception e) {
            throw new DealClaimFailure(e.getMessage());
        }
    }
}
