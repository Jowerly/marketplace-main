package com.groupproyect.marketplace.repository.order;

import java.util.List;

import com.groupproyect.marketplace.model.order.Order;
import com.groupproyect.marketplace.repository.BaseWithDateRepository;

public interface OrderRepository extends BaseWithDateRepository<Order> {
  List<Order> findByClientId(Long clientId);
}
