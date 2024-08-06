package com.groupproyect.marketplace.model.purchase;

import com.groupproyect.marketplace.model.BaseModelWithDate;
import com.groupproyect.marketplace.model.delivery.DeliveryMethod;
import com.groupproyect.marketplace.model.order.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "invoices")
@Getter
@Setter
public class Invoice extends BaseModelWithDate {
  private Double iva;

  // Table with Foreign Key
  // Table: orders FK
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;

  // Table with Foreign Key
  // Table: payment_methods FK
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payment_method_id")
  private PaymentMethod paymentMethod;

  // Table with Foreign Key
  // Table: delivery_methods FK
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "delivery_method_id")
  private DeliveryMethod deliveryMethod;
}