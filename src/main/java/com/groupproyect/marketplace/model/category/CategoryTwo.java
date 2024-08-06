package com.groupproyect.marketplace.model.category;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories_two")
@Getter
@Setter
public class CategoryTwo extends BaseCategory {
  // Table with Foreign Key
  // Table: categories_one FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categoryOne_id")
  private CategoryOne categoryOne;

  /* */

  // Referenced Table
  // Table: categories_three FK
  @OneToMany(mappedBy="categoryTwo", fetch = FetchType.LAZY)
  private List<CategoryThree> categoryThrees;
}
