package com.groupproyect.marketplace.model.user;

import java.util.List;

import com.groupproyect.marketplace.model.cite.District;
import com.groupproyect.marketplace.model.order.Order;
import com.groupproyect.marketplace.model.product.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client extends BaseUser {
  // Table with Foreign Key
  // Table: districts FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "directions_clients", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "district_id"))
  private List<District> districts;

  /* */

  // Referenced Table
  // Table: orders FK
  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Order> orders;

  // Referenced Table
  // Table: categories_three FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "products_clients_cache", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products;
}
