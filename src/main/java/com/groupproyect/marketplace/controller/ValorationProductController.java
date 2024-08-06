package com.groupproyect.marketplace.controller;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupproyect.marketplace.service.valoration.ValorationProductService;
import com.groupproyect.marketplace.model.valoration.ValorationProduct;
import com.groupproyect.marketplace.service.product.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/valorationproduct")
public class ValorationProductController {
  private final ValorationProductService valorationProductService;

  public ValorationProductController(ValorationProductService valorationProductService, ProductService productService) {
    this.valorationProductService = valorationProductService;
  }

  @PostMapping({ "/new", "/new/" })

  public String newvalorationProduct(@Valid @ModelAttribute("ValorationProduct") ValorationProduct valorationProduct,
      BindingResult result) {
    Long idProduct = valorationProduct.getProduct().getId();
    if (result.hasErrors()) {
      return "redirect:/valorationproduct/" + idProduct;
    }
    valorationProductService.save(valorationProduct);
    return "redirect:/products/" + idProduct;
  }
}