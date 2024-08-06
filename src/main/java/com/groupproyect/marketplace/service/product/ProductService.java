package com.groupproyect.marketplace.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.product.Product;
import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.repository.product.ProductRepository;
import com.groupproyect.marketplace.service.BaseService;

@Service
public class ProductService extends BaseService<Product> {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    super(productRepository);
    this.productRepository = productRepository;
  }

  public List<Product> findByStoreId(Long idStore) {
    return productRepository.findByStoreId(idStore);
  }

  public List<Product> findByStore(Store store) {
    return productRepository.findByStore(store);
  }

  public List<Product> findByCategoryThreeId(Long idCategoryThree) {
    return productRepository.findByCategoryThreeId(idCategoryThree);
  }
}
