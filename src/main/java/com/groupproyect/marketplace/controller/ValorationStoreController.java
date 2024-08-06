package com.groupproyect.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupproyect.marketplace.model.valoration.ValorationStore;
import com.groupproyect.marketplace.service.store.StoreService;
import com.groupproyect.marketplace.service.valoration.ValorationStoreService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/valoration-store")
public class ValorationStoreController {
  private final ValorationStoreService valorationStoreService;

  public ValorationStoreController(ValorationStoreService valorationStoreService, StoreService storeService) {
    this.valorationStoreService = valorationStoreService;
  }

  @PostMapping({ "/new", "/new/" })
  public String createValorationStore(@Valid @ModelAttribute("valorationStore") ValorationStore valorationStore,
      BindingResult result) {
    Long idStore = valorationStore.getStore().getId();
    if (result.hasErrors()) {
      return "redirect:/valoration-store/" + idStore + "/new";
    }
    valorationStoreService.save(valorationStore);
    return "redirect:/stores/" + idStore;
  }
}
