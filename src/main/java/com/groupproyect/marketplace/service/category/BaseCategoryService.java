package com.groupproyect.marketplace.service.category;

import com.groupproyect.marketplace.repository.categorie.BaseCategoryRepository;
import com.groupproyect.marketplace.service.BaseService;

public class BaseCategoryService<T> extends BaseService<T> {
  @SuppressWarnings("unused")
  private BaseCategoryRepository<T> baseCategoryRepository;

  public BaseCategoryService(BaseCategoryRepository<T> baseCategoryRepository) {
    super(baseCategoryRepository);
    this.baseCategoryRepository = baseCategoryRepository;
  }
}
