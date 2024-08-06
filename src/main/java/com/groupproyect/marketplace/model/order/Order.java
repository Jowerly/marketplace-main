package com.groupproyect.marketplace.model.order;

import java.util.List;

import com.groupproyect.marketplace.model.BaseModelWithDate;
import com.groupproyect.marketplace.model.cite.District;
import com.groupproyect.marketplace.model.delivery.DeliveryStatus;
import com.groupproyect.marketplace.model.product.Product;
import com.groupproyect.marketplace.model.purchase.Invoice;
import com.groupproyect.marketplace.model.user.Client;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseModelWithDate {
  // Table with Foreign Key
  // Table: clients FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  private Client client;

  // Table with Foreign Key
  // Table: delivery_status FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "deliveryStatus_id")
  private DeliveryStatus deliveryStatus;

  /* */

  // Referenced table
  // Table: orders_products FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "orders_products", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products;

  // Referenced table
  // Table: invoice FK
  @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Invoice invoice;

  // Referenced table
  // Table: directions_orders FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "directions_orders", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "district_id"))
  private List<District> districts;
}
