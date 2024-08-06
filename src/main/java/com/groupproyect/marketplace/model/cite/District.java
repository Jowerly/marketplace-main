package com.groupproyect.marketplace.model.cite;

import java.util.List;

import com.groupproyect.marketplace.model.order.Order;
import com.groupproyect.marketplace.model.store.Local;
import com.groupproyect.marketplace.model.user.Client;
import com.groupproyect.marketplace.model.user.Seller;

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
@Table(name = "districts")
@Getter
@Setter
public class District extends BaseCite {
  // Table with Foreign Key
  // Table: departments FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private Department department;

  /* */

  // Referenced Table
  // Table: directions_locales FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "directions_locales", joinColumns = @JoinColumn(name = "district_id"), inverseJoinColumns = @JoinColumn(name = "local_id"))
  private List<Local> locals;

  // Referenced Table
  // Table: directions_sellers FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "directions_sellers", joinColumns = @JoinColumn(name = "district_id"), inverseJoinColumns = @JoinColumn(name = "seller_id"))
  private List<Seller> sellers;

  // Referenced Table
  // Table: directions_clients FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "directions_clients", joinColumns = @JoinColumn(name = "district_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))
  private List<Client> clients;

  // Referenced Table
  // Table: directions_orders FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "directions_orders", joinColumns = @JoinColumn(name = "district_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
  private List<Order> orders;
}
