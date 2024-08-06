package com.groupproyect.marketplace.model.direction;


import com.groupproyect.marketplace.model.cite.District;
import com.groupproyect.marketplace.model.order.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "directions_orders")
@Getter
@Setter
public class DirectionOrder extends BaseDirection {
  // Table with Foreign Key
  // Table: orders FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="order_id")
  private Order order;

  // Table with Foreign Key
  // Table: district FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="district_id")
  private District district;
}
