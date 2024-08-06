package com.groupproyect.marketplace.service.user;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.user.BaseUser;
import com.groupproyect.marketplace.model.user.Client;
import com.groupproyect.marketplace.repository.user.ClientRepository;

@Service
public class ClientService extends BaseUserService<Client> {
  @SuppressWarnings("unused")
  private final ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    super(clientRepository);
    this.clientRepository = clientRepository;
  }

  public Client castFromBaseUser(BaseUser baseUser) {
    Client client = new Client();
    client.setFirstName(baseUser.getFirstName());
    client.setLastName(baseUser.getLastName());
    client.setEmail(baseUser.getEmail());
    client.setTelephoneNumber(baseUser.getTelephoneNumber());
    client.setNumberDocumentIdentity(baseUser.getNumberDocumentIdentity());
    client.setPassword(baseUser.getPassword());
    return client;
  }
}