package com.groupproyect.marketplace.model.category;

import java.util.List;

import com.groupproyect.marketplace.model.store.Store;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories_one")
@Getter
@Setter
public class CategoryOne extends BaseCategory {
  private String linkImage;

  // Referenced Table
  // Table: categories_two
  @OneToMany(mappedBy="categoryOne", fetch = FetchType.LAZY)
  private List<CategoryTwo> categoryTwos;

  // Referenced Table
  // Table: stores
  @OneToMany(mappedBy="categoryOne", fetch = FetchType.LAZY)
  private List<Store> stores;
}