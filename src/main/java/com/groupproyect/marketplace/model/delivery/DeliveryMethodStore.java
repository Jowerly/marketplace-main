package com.groupproyect.marketplace.model.delivery;

import com.groupproyect.marketplace.model.BaseModel;
import com.groupproyect.marketplace.model.store.Store;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "deliverys_methods_stores")
@Getter
@Setter
public class DeliveryMethodStore extends BaseModel {
  // Table with Foreign Key
  // Table: store FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_id")
  private Store store;

  // Table with Foreign Key
  // Table: delivery_methods FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "deliveryMethod_id")
  private DeliveryMethod deliveryMethod;
}