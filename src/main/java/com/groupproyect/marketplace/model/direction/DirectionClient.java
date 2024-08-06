package com.groupproyect.marketplace.model.direction;



import com.groupproyect.marketplace.model.cite.District;
import com.groupproyect.marketplace.model.user.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "directions_clients")
@Getter
@Setter
public class DirectionClient extends BaseDirection {
  // Table with Foreign Key
  // Table: district FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="district_id")
  private District district;

  // Table with Foreign Key
  // Table: client FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="client_id")
  private Client client;
}
