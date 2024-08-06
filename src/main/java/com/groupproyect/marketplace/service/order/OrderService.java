package com.groupproyect.marketplace.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.order.Order;
import com.groupproyect.marketplace.repository.order.OrderRepository;
import com.groupproyect.marketplace.service.BaseWithDateService;

@Service
public class OrderService extends BaseWithDateService<Order> {
  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    super(orderRepository);
    this.orderRepository = orderRepository;
  }

  public List<Order> findByClientId(Long clientId) {
    return orderRepository.findByClientId(clientId);
  }
}
