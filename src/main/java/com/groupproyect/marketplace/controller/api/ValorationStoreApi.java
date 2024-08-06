package com.groupproyect.marketplace.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupproyect.marketplace.model.valoration.ValorationStore;
import com.groupproyect.marketplace.service.valoration.ValorationStoreService;

@RestController
@RequestMapping("/api/valorations")
public class ValorationStoreApi {
  private final ValorationStoreService valorationStoreService;

  public ValorationStoreApi(ValorationStoreService valorationStoreService) {
    this.valorationStoreService = valorationStoreService;
  }

  @GetMapping("")
  public List<ValorationStore> findAllValorations() {
    return valorationStoreService.findAll();
  }

  @PostMapping("")
  public ValorationStore createValoration(@RequestBody ValorationStore valorationStore) {
    return valorationStoreService.save(valorationStore);
  }
}
