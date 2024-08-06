package com.groupproyect.marketplace.model.valoration;

import com.groupproyect.marketplace.model.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "valorations_products")
@Getter
@Setter
public class ValorationProduct extends BaseValoration {
  // Table with Foreign Key
  // Table: products FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;
}