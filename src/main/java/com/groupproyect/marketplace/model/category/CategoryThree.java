package com.groupproyect.marketplace.model.category;

import java.util.List;

import com.groupproyect.marketplace.model.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories_three")
@Getter
@Setter
public class CategoryThree extends BaseCategory {
  // Table with Foreign Key
  // Table: categories_two FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categoryTwo_id")
  private CategoryTwo categoryTwo;

  /* */

  // Referenced Table
  // Table: products
  @OneToMany(mappedBy="categoryThree", fetch = FetchType.LAZY)
  private List<Product> products;
}
