package com.groupproyect.marketplace.model.direction;

import com.groupproyect.marketplace.model.cite.District;
import com.groupproyect.marketplace.model.store.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "directions_locales")
@Getter
@Setter
public class DirectionLocal extends BaseDirection {
  // Table with Foreign Key
  // Table: district FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "district_id")
  private District district;

  // Table with Foreign Key
  // Table: local FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "local_id")
  private Local local;
}