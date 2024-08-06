package com.groupproyect.marketplace.repository.categorie;

import java.util.List;

import com.groupproyect.marketplace.model.category.CategoryThree;
import com.groupproyect.marketplace.model.product.Product;

public interface CategoryThreeRepository extends BaseCategoryRepository<CategoryThree> {
  List<Product> findProductById(Long id);

  List<CategoryThree> findByCategoryTwoId(Long idCategoryTwo);
}
