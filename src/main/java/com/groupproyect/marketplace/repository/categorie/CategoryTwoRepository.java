package com.groupproyect.marketplace.repository.categorie;

import java.util.List;

import com.groupproyect.marketplace.model.category.CategoryTwo;

public interface CategoryTwoRepository extends BaseCategoryRepository<CategoryTwo> {
  List<CategoryTwo> findByCategoryOneId(Long categoryOneId);
}
