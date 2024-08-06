package com.groupproyect.marketplace.service.direction;

import com.groupproyect.marketplace.repository.direction.BaseDirectionRepository;
import com.groupproyect.marketplace.service.BaseWithDateService;

public class BaseDirectionService<T> extends BaseWithDateService<T> {
  @SuppressWarnings("unused")
  private final BaseDirectionRepository<T> baseDirectionRepository;

  public BaseDirectionService(BaseDirectionRepository<T> baseDirectionRepository) {
    super(baseDirectionRepository);
    this.baseDirectionRepository = baseDirectionRepository;
  }
}
