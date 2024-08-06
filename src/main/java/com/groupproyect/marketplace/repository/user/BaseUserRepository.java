package com.groupproyect.marketplace.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import com.groupproyect.marketplace.repository.BaseWithDateRepository;

@NoRepositoryBean
public interface BaseUserRepository<T> extends BaseWithDateRepository<T> {
  public boolean existsByEmail(String email);
  public T findByEmail(String email);
  @Query("SELECT c.id FROM Client c WHERE c.email = :email")
  Long getIdByEmail(@Param("email") String email);
}
