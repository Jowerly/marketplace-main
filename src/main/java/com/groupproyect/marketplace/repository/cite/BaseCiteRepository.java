package com.groupproyect.marketplace.repository.cite;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.groupproyect.marketplace.repository.BaseRepository;

@NoRepositoryBean
public interface BaseCiteRepository<T> extends BaseRepository<T> {
  List<T> findAllByOrderByNameAsc();
}
