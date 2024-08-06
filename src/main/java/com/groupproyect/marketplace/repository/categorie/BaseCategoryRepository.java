package com.groupproyect.marketplace.repository.categorie;

import org.springframework.data.repository.NoRepositoryBean;

import com.groupproyect.marketplace.repository.BaseRepository;

@NoRepositoryBean
public interface BaseCategoryRepository<T> extends BaseRepository<T> {
  
}
