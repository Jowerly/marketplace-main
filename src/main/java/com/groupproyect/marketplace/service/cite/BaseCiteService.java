package com.groupproyect.marketplace.service.cite;

import java.util.List;

import com.groupproyect.marketplace.repository.cite.BaseCiteRepository;
import com.groupproyect.marketplace.service.BaseService;

public class BaseCiteService<T> extends BaseService<T> {
  private final BaseCiteRepository<T> baseCiteRepository;

  public BaseCiteService(BaseCiteRepository<T> baseCiteRepository) {
    super(baseCiteRepository);
    this.baseCiteRepository = baseCiteRepository;
  }

  public List<T> findAllByOrderByNameAsc() {
    return baseCiteRepository.findAllByOrderByNameAsc();
  }
}
