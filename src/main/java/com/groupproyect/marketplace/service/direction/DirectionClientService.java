package com.groupproyect.marketplace.service.direction;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.direction.DirectionClient;
import com.groupproyect.marketplace.repository.direction.DirectionClientRepository;

@Service
public class DirectionClientService extends BaseDirectionService<DirectionClient> {

    @SuppressWarnings("unused")
    private final DirectionClientRepository directionClientRepository;
    
    public DirectionClientService(DirectionClientRepository directionClientRepository) {
    super(directionClientRepository);
    this.directionClientRepository = directionClientRepository;
    }
}
