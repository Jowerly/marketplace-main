package com.groupproyect.marketplace.model.store;

import java.time.LocalTime;
import java.util.List;

import com.groupproyect.marketplace.model.BaseModelWithDate;
import com.groupproyect.marketplace.model.cite.District;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "locales")
@Getter
@Setter
public class Local extends BaseModelWithDate {
  private LocalTime openingHours;
  private LocalTime closingHours;

  // Table with Foreign Key
  // Table: stores FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_id")
  private Store store;

  /* */

  // Referenced Table
  // Table: districts FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "directions_locales", joinColumns = @JoinColumn(name = "local_id"), inverseJoinColumns = @JoinColumn(name = "district_id"))
  private List<District> districts;
}
