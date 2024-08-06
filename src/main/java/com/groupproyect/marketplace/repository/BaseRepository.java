package com.groupproyect.marketplace.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T> extends CrudRepository<T, Long> {
  @SuppressWarnings("null")
  List<T> findAll();
  boolean existsById(@SuppressWarnings("null") Long id);
}