package org.example.limiteddeal.models.request;

import org.example.limiteddeal.exception.EntityNotFound;
import org.example.limiteddeal.exception.InvalidDealUpdate;
import org.example.limiteddeal.service.DealService;

public enum DealUpdateType {
    UPDATE_DISCOUNT(){
        @Override
        public void validate(UpdateDealRequest updateDealRequest) {
// TODO: //
        }

        @Override
        public void performUpdate(DealService dealService, UpdateDealRequest request) throws EntityNotFound {
            dealService.updateDiscount(request.getDealId(), request.discount);
        }
    },
    UPDATE_START_TIME(){
        @Override
        public void validate(UpdateDealRequest updateDealRequest) {

        }

        @Override
        public void performUpdate(DealService dealService, UpdateDealRequest request) throws InvalidDealUpdate, EntityNotFound {
            dealService.updateDealStartTime(request.getDealId(), request.startTime);
        }
    },
    UPDATE_PRODUCT(){
        @Override
        public void validate(UpdateDealRequest updateDealRequest) {

        }

        @Override
        public void performUpdate(DealService dealService, UpdateDealRequest request) throws EntityNotFound {
            dealService.updateProduct(request.getDealId(), request.getProduct().getProductId(), request.getProduct().getNewLimit());
        }
    },
    UPDATE_END_TIME(){
        @Override
        public void validate(UpdateDealRequest updateDealRequest) {

        }

        @Override
        public void performUpdate(DealService dealService, UpdateDealRequest request) throws InvalidDealUpdate, EntityNotFound {
            dealService.updateDealEndTime(request.getDealId(), request.endTime);
        }
    };

    abstract public void validate(UpdateDealRequest updateDealRequest);

    abstract public void performUpdate(DealService dealService, UpdateDealRequest request) throws EntityNotFound, InvalidDealUpdate;
}


// TODO: this should be converted to a factory pattern based on the updateType. i.e factory.getUpdateProcesor(updateType).update()