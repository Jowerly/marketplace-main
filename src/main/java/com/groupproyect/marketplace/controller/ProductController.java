package com.groupproyect.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupproyect.marketplace.model.product.Product;
import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.model.valoration.ValorationProduct;
import com.groupproyect.marketplace.service.category.CategoryOneService;
import com.groupproyect.marketplace.service.category.CategoryThreeService;
import com.groupproyect.marketplace.service.category.CategoryTwoService;
import com.groupproyect.marketplace.service.product.ProductService;
import com.groupproyect.marketplace.service.store.StoreService;
import com.groupproyect.marketplace.service.valoration.ValorationProductService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;
  private final StoreService storeService;
  private final CategoryOneService categoryOneService;
  private final CategoryTwoService categoryTwoService;
  private final CategoryThreeService categoryThreeService;
  private final ValorationProductService valorationProductService;

  public ProductController(ProductService productService, StoreService storeService,
      CategoryOneService categoryOneService, CategoryTwoService categoryTwoService,
      CategoryThreeService categoryThreeService, ValorationProductService valorationProductService) {
    this.productService = productService;
    this.storeService = storeService;
    this.categoryOneService = categoryOneService;
    this.categoryTwoService = categoryTwoService;
    this.categoryThreeService = categoryThreeService;
    this.valorationProductService = valorationProductService;
  }

  @GetMapping({ "", "/" })
  public String products(@ModelAttribute("product") Product product, Model model) {
    model.addAttribute("productos", productService.findAll());
    model.addAttribute("categoriesOne", categoryOneService.findAll());
    return "/product/products.jsp";
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public String showProduct(@PathVariable("id") Long id,
      @ModelAttribute("ValorationProduct") ValorationProduct valorationProduct, Model model) {
    model.addAttribute("product", productService.findById(id));
    model.addAttribute("valorationsStore", valorationProductService.findByProductIdOrderByCreatedAtDesc(id));
    return "product/product-show.jsp";
  }

  @GetMapping({ "/new", "/new/" })
  public String newProduct(
      @ModelAttribute("product") Product product,
      @ModelAttribute("store") Store store, HttpSession httpSession, Model model) {
    model.addAttribute("store", 1);
    model.addAttribute("categoriesOnes", categoryOneService.findAll());
    model.addAttribute("categoriesTwos", categoryTwoService.findAll());
    model.addAttribute("categoriesThrees", categoryThreeService.findAll());
    return "/product/product-new.jsp";
  }

  @GetMapping({ "/{id}/coments", "/{id}/coments" })
  public String coments(@PathVariable("id") Long id,
      @ModelAttribute("ValorationProduct") ValorationProduct valorationProduct,
      Model model, HttpSession httpSession) {

    model.addAttribute("product", productService.findById(id));
    model.addAttribute("valorationsProduct", valorationProductService.findAll());
    return "product/product-showcoments.jsp";
  }

  @PostMapping("new")
  public String createProduct(
      @Valid @ModelAttribute("product") Product product, BindingResult result, Model model,
      @RequestParam("categoryThree") Long idCategoryThree,
      HttpSession httpSession, RedirectAttributes redirectAttributes) {
    if ((httpSession.getAttribute("idUser")) == null) {
      redirectAttributes.addFlashAttribute("userError", "No estas logeado.");
      return "redirect:/stores/new";
    }
    if (((String) httpSession.getAttribute("roleUser")) != "seller") {
      redirectAttributes.addFlashAttribute("roleError",
          "Solo los vendedores pueden registar su tienda, puedes crear otra cuenta.");
      return "redirect:/stores/new";
    }
    if (result.hasErrors()) {
      return "/product/product-new.jsp";
    } else {
      Long idUser = (Long) httpSession.getAttribute("idUser");
      product.setStore(storeService.findBySellerId(idUser));
      product.setCategoryThree(categoryThreeService.findById(idCategoryThree));
      Long idProduct = productService.save(product).getId();
      return "redirect:/products/" + idProduct;
    }
  }
}
