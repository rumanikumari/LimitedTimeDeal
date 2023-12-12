package org.example.limiteddeal;

import org.example.limiteddeal.exception.DealClaimFailure;
import org.example.limiteddeal.exception.DealCreationFailed;
import org.example.limiteddeal.exception.InvalidRequest;
import org.example.limiteddeal.models.Deal;
import org.example.limiteddeal.models.request.CreateDealRequest;
import org.example.limiteddeal.models.request.DealUpdateType;
import org.example.limiteddeal.models.request.ProductUpdate;
import org.example.limiteddeal.models.request.UpdateDealRequest;
import org.example.limiteddeal.repositories.DealRepository;
import org.example.limiteddeal.service.CustomerPlatform;
import org.example.limiteddeal.service.DealService;
import org.example.limiteddeal.service.SellerPlatform;

import java.util.HashMap;
import java.util.Map;

public class LimitedDealApplication {


    public static void main( String[] args ) throws DealClaimFailure, DealCreationFailed, InvalidRequest {
        DealRepository dealRepository = new DealRepository();
        DealService dealService = new DealService(dealRepository);
        SellerPlatform sellerPlatform = new SellerPlatform(dealService);
        CustomerPlatform customerPlatform = new CustomerPlatform(dealService);
        // TODO: all these should be Singletons

        Map<String, Integer> products = new HashMap<String, Integer>(){{
            put("pid1", 2);
            put("pid2", 1);
        }};
        CreateDealRequest createDealRequest = new CreateDealRequest(10, products, null, null);
        Deal deal = sellerPlatform.createDeal(createDealRequest);
        customerPlatform.claimDeal(deal.getId(), "pid2");
        UpdateDealRequest updateDealRequest = new UpdateDealRequest(deal.getId(), DealUpdateType.UPDATE_PRODUCT, null,
                new ProductUpdate("pid2", 3), null, null);
        sellerPlatform.updateDeal(updateDealRequest);
    }
}
