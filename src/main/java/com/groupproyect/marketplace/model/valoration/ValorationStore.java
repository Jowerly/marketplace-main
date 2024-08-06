package com.groupproyect.marketplace.model.valoration;

import com.groupproyect.marketplace.model.store.Store;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "valorations_stores")
@Getter
@Setter
public class ValorationStore extends BaseValoration {
  // Table with Foreign Key
  // Table: stores FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_id")
  private Store store;
}