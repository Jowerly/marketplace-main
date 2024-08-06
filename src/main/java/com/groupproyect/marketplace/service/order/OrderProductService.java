package com.groupproyect.marketplace.service.order;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.order.OrderProduct;
import com.groupproyect.marketplace.repository.order.OrderProductRepository;
import com.groupproyect.marketplace.service.BaseWithDateService;

@Service
public class OrderProductService extends BaseWithDateService<OrderProduct> {
  @SuppressWarnings("unused")
  private final OrderProductRepository orderProductRepository;

  public OrderProductService(OrderProductRepository orderProductRepository) {
    super(orderProductRepository);
    this.orderProductRepository = orderProductRepository;
  }
}
