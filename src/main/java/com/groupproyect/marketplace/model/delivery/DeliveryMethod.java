package com.groupproyect.marketplace.model.delivery;

import java.util.List;

import com.groupproyect.marketplace.model.BaseModel;
import com.groupproyect.marketplace.model.purchase.Invoice;
import com.groupproyect.marketplace.model.store.Store;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "delivery_methods")
@Getter
@Setter
public class DeliveryMethod extends BaseModel {
  private String name;

  // Referenced Table
  // Table: deliverys_methods_stores FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "deliverys_methods_stores", joinColumns = @JoinColumn(name = "deliveryMethod_id"), inverseJoinColumns = @JoinColumn(name = "store_id"))
  private List<Store> stores;

  // Referenced Table
  // Table: invoice FK
  @OneToOne(mappedBy = "deliveryMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Invoice invoice;
}