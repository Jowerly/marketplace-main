package com.groupproyect.marketplace.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupproyect.marketplace.model.user.Seller;
import com.groupproyect.marketplace.service.user.SellerService;

@RestController
@RequestMapping("/api/sellers")
public class SellerApi {
  private final SellerService sellerService;

  public SellerApi(SellerService sellerService) {
    this.sellerService = sellerService;
  }

  @GetMapping({ "", "/" })
  public List<Seller> findAllSellers() {
    return sellerService.findAll();
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public Seller findByIdSeller(@PathVariable("id") Long id) {
    return sellerService.findById(id);
  }

  // @PostMapping("")
  // public Seller createSeller(@Valid @ModelAttribute Seller seller) {
  // return sellerService.save(seller);
  // }

  @DeleteMapping("/{id}")
  public void deleteByIdSeller(@PathVariable("id") Long id) {
    sellerService.deleteById(id);
  }
}