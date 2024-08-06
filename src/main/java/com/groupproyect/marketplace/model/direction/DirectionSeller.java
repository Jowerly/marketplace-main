package com.groupproyect.marketplace.model.direction;


import com.groupproyect.marketplace.model.cite.District;
import com.groupproyect.marketplace.model.user.Seller;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "directions_sellers")
@Getter
@Setter
public class DirectionSeller extends BaseDirection {
  // Table with Foreign Key
  // Table: district FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="district_id")
  private District district;

  // Table with Foreign Key
  // Table: sellers FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="seller_id")
  private Seller seller;
}