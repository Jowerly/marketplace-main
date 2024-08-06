package com.groupproyect.marketplace.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupproyect.marketplace.model.user.Client;
import com.groupproyect.marketplace.service.user.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientApi {
  private final ClientService clientService;

  public ClientApi(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping({ "", "/" })
  public List<Client> findAllClients() {
    return clientService.findAll();
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public Client findByIdClient(@PathVariable("id") Long id) {
    return clientService.findById(id);
  }

  // @PostMapping("")
  // public Client createClient(@Valid @ModelAttribute("client") Client client) {
  // return clientService.save(client);
  // }

  @DeleteMapping("/{id}")
  public void deleteByIdClient(@PathVariable("id") Long id) {
    clientService.deleteById(id);
  }
}