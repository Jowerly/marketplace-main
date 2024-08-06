package com.groupproyect.marketplace.model.monetization;

import java.util.List;

import com.groupproyect.marketplace.model.BaseModel;

import com.groupproyect.marketplace.model.user.Seller;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "memberships")
@Getter
@Setter
public class Membership extends BaseModel {
  private String name;
  private Double price;
  private Integer months;

  // Referenced table
  // Table: memberships_sellers FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "memberships_sellers", joinColumns = @JoinColumn(name = "membership_id"), inverseJoinColumns = @JoinColumn(name = "seller_id"))
  private List<Seller> sellers;
}