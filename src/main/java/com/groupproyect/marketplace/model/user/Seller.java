package com.groupproyect.marketplace.model.user;

import java.util.List;

import com.groupproyect.marketplace.model.cite.District;
import com.groupproyect.marketplace.model.monetization.Membership;
import com.groupproyect.marketplace.model.store.Store;

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
@Table(name = "sellers")
@Getter
@Setter
public class Seller extends BaseUser {
  // Table with Foreign Key
  // Table: stores FK
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_id")
  private Store store;

  // Table with Foreign Key
  // Table: districts FK (Many-to-Many relationship)
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "directions_sellers", joinColumns = @JoinColumn(name = "seller_id"), inverseJoinColumns = @JoinColumn(name = "district_id"))
  private List<District> districts;

  /* */

  // Referenced Table
  // Table: memberships FK (Many-to-Many relationship)
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "memberships_sellers", joinColumns = @JoinColumn(name = "seller_id"), inverseJoinColumns = @JoinColumn(name = "membership_id"))
  private List<Membership> memberships;
}