package com.groupproyect.marketplace.service.direction;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.direction.DirectionLocal;
import com.groupproyect.marketplace.repository.direction.DirectionLocalRepository;

@Service
public class DirectionLocalService extends BaseDirectionService<DirectionLocal> {
  @SuppressWarnings("unused")
  private final DirectionLocalRepository directionLocalRepository;

  public DirectionLocalService(DirectionLocalRepository directionLocalRepository) {
    super(directionLocalRepository);
    this.directionLocalRepository = directionLocalRepository;
  }
}
