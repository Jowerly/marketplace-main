package com.groupproyect.marketplace.repository.product;

import java.util.List;

import com.groupproyect.marketplace.model.category.CategoryThree;
import com.groupproyect.marketplace.model.product.Product;
import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.repository.BaseRepository;

public interface ProductRepository extends BaseRepository<Product> {
  List<Product> findByStoreId(Long idStore);

  List<Product> findByStore(Store store);

  List<Product> findByCategoryThreeId(Long idCategoryThree);

  List<Product> findByCategoryThree(CategoryThree categoryThree);
}
