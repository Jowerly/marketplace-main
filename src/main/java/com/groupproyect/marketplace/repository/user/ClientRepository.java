package com.groupproyect.marketplace.repository.user;

import com.groupproyect.marketplace.model.user.Client;

public interface ClientRepository extends BaseUserRepository<Client> {
  public boolean existsByEmail(String email);
  public Client findByEmail(String email);
  Long getIdByEmail(String email);
}
