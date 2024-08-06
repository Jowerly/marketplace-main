package com.groupproyect.marketplace.repository.direction;

import org.springframework.data.repository.NoRepositoryBean;

import com.groupproyect.marketplace.repository.BaseWithDateRepository;

@NoRepositoryBean
public interface BaseDirectionRepository<T> extends BaseWithDateRepository<T> {
  
}
