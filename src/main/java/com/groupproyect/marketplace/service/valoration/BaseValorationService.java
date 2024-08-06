package com.groupproyect.marketplace.service.valoration;

import com.groupproyect.marketplace.repository.valoration.BaseValorationRepository;
import com.groupproyect.marketplace.service.BaseWithDateService;

public class BaseValorationService<T> extends BaseWithDateService<T> {
  @SuppressWarnings("unused")
  private final BaseValorationRepository<T> baseValorationRepository;

  public BaseValorationService(BaseValorationRepository<T> baseValorationRepository) {
    super(baseValorationRepository);
    this.baseValorationRepository = baseValorationRepository;
  }
}
