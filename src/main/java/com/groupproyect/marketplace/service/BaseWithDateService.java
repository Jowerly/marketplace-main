package com.groupproyect.marketplace.service;

import com.groupproyect.marketplace.repository.BaseRepository;

public class BaseWithDateService<T> extends BaseService<T> {
  @SuppressWarnings("unused")
  private final BaseRepository<T> baseRepository;

  public BaseWithDateService(BaseRepository<T> baseRepository) {
    super(baseRepository);
    this.baseRepository = baseRepository;
  }
}
