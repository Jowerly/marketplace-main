package com.groupproyect.marketplace.service.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.category.CategoryThree;
import com.groupproyect.marketplace.model.product.Product;
import com.groupproyect.marketplace.repository.categorie.CategoryThreeRepository;

@Service
public class CategoryThreeService extends BaseCategoryService<CategoryThree>{
  private final CategoryThreeRepository categoryThreeRepository;

  public CategoryThreeService(CategoryThreeRepository categoryThreeRepository) {
    super(categoryThreeRepository);
    this.categoryThreeRepository = categoryThreeRepository;
  }

  public List<Product> findProductsById(Long id) {
    return categoryThreeRepository.findProductById(id);
  }

  public List<CategoryThree> findByCategoryTwoId(Long idCategoryTwo) {
    return categoryThreeRepository.findByCategoryTwoId(idCategoryTwo);
  }
}
