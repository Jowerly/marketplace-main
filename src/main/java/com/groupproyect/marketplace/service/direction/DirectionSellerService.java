package com.groupproyect.marketplace.service.direction;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.direction.DirectionSeller;

import com.groupproyect.marketplace.repository.direction.DirectionSellerRepository;

@Service
public class DirectionSellerService extends BaseDirectionService<DirectionSeller> {
    

    @SuppressWarnings("unused")
    private final DirectionSellerRepository directionSellerRepository;

    public DirectionSellerService(DirectionSellerRepository directionSellerRepository) {
        super(directionSellerRepository);
        this.directionSellerRepository = directionSellerRepository;
    }
}
