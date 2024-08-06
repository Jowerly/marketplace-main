package com.groupproyect.marketplace.service.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.category.CategoryTwo;
import com.groupproyect.marketplace.repository.categorie.CategoryTwoRepository;

@Service
public class CategoryTwoService extends BaseCategoryService<CategoryTwo> {
  private final CategoryTwoRepository categoryTwoRepository;

  public CategoryTwoService(CategoryTwoRepository categoryTwoRepository) {
    super(categoryTwoRepository);
    this.categoryTwoRepository = categoryTwoRepository;
  }

  public List<CategoryTwo> findByCategoryOneId(Long categoryOneId) {
    return categoryTwoRepository.findByCategoryOneId(categoryOneId);
  }
}
