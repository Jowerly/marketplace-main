package com.groupproyect.marketplace.repository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseWithDateRepository<T> extends BaseRepository<T> {
  
}
