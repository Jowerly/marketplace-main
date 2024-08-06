package com.groupproyect.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupproyect.marketplace.service.category.CategoryOneService;
import com.groupproyect.marketplace.service.user.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
  private final ClientService clientService;
    private final CategoryOneService categoryOneService;


  public ClientController(ClientService clientService, CategoryOneService categoryOneService) {
    this.clientService = clientService;
    this.categoryOneService = categoryOneService;
  }

  @GetMapping({ "/{idClient}", "/{idClient}/" })
  public String showClient(@PathVariable("idClient") Long idClient, Model model) {
    model.addAttribute("client", clientService.findById(idClient));
    model.addAttribute("categoriesOne", categoryOneService.findAll());
    return "user/client-show.jsp";
  }
}
