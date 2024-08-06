package com.groupproyect.marketplace.model.cache;

import com.groupproyect.marketplace.model.BaseModel;
import com.groupproyect.marketplace.model.product.Product;
import com.groupproyect.marketplace.model.user.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products_clients_cache")
@Getter
@Setter
public class ProductClientCache extends BaseModel {
  private Integer amount;

  // Table with Foreign Key
  // Table: store FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  private Client client;

  // Table with Foreign Key
  // Table: store FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;
}
