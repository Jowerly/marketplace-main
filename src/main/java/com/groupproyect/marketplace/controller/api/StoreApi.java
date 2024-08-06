package com.groupproyect.marketplace.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.service.store.StoreService;

@RestController
@RequestMapping("/api/stores")
public class StoreApi {
  private final StoreService storeService;

  public StoreApi(StoreService storeService) {
    this.storeService = storeService;
  }

  @GetMapping({ "", "/" })
  public List<Store> findAllStores() {
    return storeService.findAll();
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public Store findByIdStore(@PathVariable("id") Long id) {
    return storeService.findById(id);
  }

  // @PostMapping("")
  // public Seller createSeller(@Valid @ModelAttribute Seller seller) {
  // return sellerService.save(seller);
  // }

  @DeleteMapping("/{id}")
  public void deleteByIdStore(@PathVariable("id") Long id) {
    storeService.deleteById(id);
  }
}
