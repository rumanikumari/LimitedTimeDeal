package org.example.limiteddeal.repositories;

import org.example.limiteddeal.exception.EntityNotFound;
import org.example.limiteddeal.models.Deal;

import java.util.HashMap;
import java.util.Map;

public class DealRepository {
    private Map<Integer, Deal> deals;

    public DealRepository() {
        this.deals = new HashMap<>();
    }

    public void addDeal(Deal deal){
        this.deals.put(deal.getId(), deal);
    }

    public Deal getDeal(Integer id) throws EntityNotFound {
        if(!deals.containsKey(id))
            throw new EntityNotFound("Deal not found for id: "+ id);
        return deals.get(id);
    }
}
