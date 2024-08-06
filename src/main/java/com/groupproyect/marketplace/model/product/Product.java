package com.groupproyect.marketplace.model.product;

import java.util.List;

import com.groupproyect.marketplace.model.BaseModelWithDate;
import com.groupproyect.marketplace.model.category.CategoryThree;
import com.groupproyect.marketplace.model.order.Order;
import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.model.user.Client;
import com.groupproyect.marketplace.model.valoration.ValorationProduct;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseModelWithDate {
  private String name;
  private Double price;
  private String linkImage;

  // Table with Foreign Key
  // Table: store FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_id")
  private Store store;

  // Table with Foreign Key
  // Table: categories_three FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categoryThree_id")
  private CategoryThree categoryThree;

  /* */

  // Referenced table
  // Table: valorations_products FK
  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
  private List<ValorationProduct> valorationProducts;

  // Referenced table
  // Table: orders_products FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "orders_products", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
  private List<Order> orders;

  // Referenced Table
  // Table: categories_three FK
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "products_clients_cache", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))
  private List<Client> clients;
}
