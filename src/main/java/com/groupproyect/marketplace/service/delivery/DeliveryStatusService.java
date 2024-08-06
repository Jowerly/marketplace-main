package com.groupproyect.marketplace.service.delivery;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.delivery.DeliveryStatus;
import com.groupproyect.marketplace.repository.delivery.DeliveryStatusRepository;
import com.groupproyect.marketplace.service.BaseService;

@Service
public class DeliveryStatusService extends BaseService<DeliveryStatus> {
  @SuppressWarnings("unused")
  private final DeliveryStatusRepository deliveryStatusRepository;

  public DeliveryStatusService(DeliveryStatusRepository deliveryStatusRepository) {
    super(deliveryStatusRepository);
    this.deliveryStatusRepository = deliveryStatusRepository;
  }
}
