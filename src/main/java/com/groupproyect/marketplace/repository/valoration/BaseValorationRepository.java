package com.groupproyect.marketplace.repository.valoration;

import org.springframework.data.repository.NoRepositoryBean;

import com.groupproyect.marketplace.repository.BaseWithDateRepository;

@NoRepositoryBean
public interface BaseValorationRepository<T> extends BaseWithDateRepository<T> {
  
}
