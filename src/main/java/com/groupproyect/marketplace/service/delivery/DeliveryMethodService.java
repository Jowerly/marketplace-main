package com.groupproyect.marketplace.service.delivery;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.delivery.DeliveryMethod;
import com.groupproyect.marketplace.repository.delivery.DeliveryMethodRepository;
import com.groupproyect.marketplace.service.BaseService;

@Service
public class DeliveryMethodService extends BaseService<DeliveryMethod> {
  @SuppressWarnings("unused")
  private final DeliveryMethodRepository deliveryMethodRepository;

  public DeliveryMethodService(DeliveryMethodRepository deliveryMethodRepository) {
    super(deliveryMethodRepository);
    this.deliveryMethodRepository = deliveryMethodRepository;
  }
    
}
