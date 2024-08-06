package com.groupproyect.marketplace.model.order;

import com.groupproyect.marketplace.model.BaseModelWithDate;
import com.groupproyect.marketplace.model.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders_products")
@Getter
@Setter
public class OrderProduct extends BaseModelWithDate {
  private Integer amount;
  private Double price;

  // Table with Foreign Key
  // Table: orders FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="order_id")
  private Order order;

  // Table with Foreign Key
  // Table: products FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="product_id")
  private Product product;
}
