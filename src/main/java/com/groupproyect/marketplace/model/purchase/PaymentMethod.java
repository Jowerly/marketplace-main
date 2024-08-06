package com.groupproyect.marketplace.model.purchase;

import com.groupproyect.marketplace.model.BaseModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment_methods")
@Getter
@Setter
public class PaymentMethod extends BaseModel {
  private String name;

  // Referenced Table
  // Table: invoices FK
  @OneToOne(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Invoice invoice;
}