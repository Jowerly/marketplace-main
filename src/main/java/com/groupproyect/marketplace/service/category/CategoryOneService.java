package com.groupproyect.marketplace.service.category;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.category.CategoryOne;
import com.groupproyect.marketplace.repository.categorie.CategoryOneRepository;

@Service
public class CategoryOneService extends BaseCategoryService<CategoryOne> {
  @SuppressWarnings("unused")
  private final CategoryOneRepository categoryOneRepository;

  public CategoryOneService(CategoryOneRepository categoryOneRepository) {
    super(categoryOneRepository);
    this.categoryOneRepository = categoryOneRepository;
  }
}
