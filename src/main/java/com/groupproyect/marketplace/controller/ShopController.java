package com.groupproyect.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupproyect.marketplace.auxclass.Card;
import com.groupproyect.marketplace.model.cache.ProductClientCache;
import com.groupproyect.marketplace.service.cache.ProductClientCacheService;
import com.groupproyect.marketplace.service.product.ProductService;
import com.groupproyect.marketplace.service.user.ClientService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/shop")
public class ShopController {
  private final ProductService productService;
  private final ClientService clientService;
  private final ProductClientCacheService productClientCacheService;

  public ShopController(ProductService productService, ProductClientCacheService productClientCacheService,
      ClientService clientService) {
    this.productService = productService;
    this.productClientCacheService = productClientCacheService;
    this.clientService = clientService;
  }

  @GetMapping({ "/cart", "/cart/" })
  public String cart(Model model, HttpSession httpSession, RedirectAttributes redirectAttributes) {
    if (((Long) httpSession.getAttribute("idUser")) == null) {
      System.out.println("Error 1: " + httpSession.getAttribute("idUser"));
      redirectAttributes.addFlashAttribute("userError", "No estas logeado.");
      return "redirect:/login";
    }
    if (!((httpSession.getAttribute("roleUser")).equals("client"))) {
      System.out.println("Error 2: " + httpSession.getAttribute("roleUser"));
      redirectAttributes.addFlashAttribute("roleError", "Solo los clientes pueden comprar, debes crear otra cuenta.");
      return "redirect:/login";
    }
    Long idClient = ((Long) httpSession.getAttribute("idUser"));
    model.addAttribute("products", productService.findAll());
    model.addAttribute("productsClientCache", productClientCacheService.findByClientId(idClient));
    return "shop/shop-cart.jsp";
  }

  @GetMapping({ "/payment", "/payment/" })
  public String payment(HttpSession httpSession, Model model, @ModelAttribute("card") Card card) {
    // Validations
    if (((Long) httpSession.getAttribute("idUser")) == null) {
      System.out.println("Error 1: " + httpSession.getAttribute("idUser"));
      return "redirect:/login";
    }
    if (!((httpSession.getAttribute("roleUser")).equals("client"))) {
      System.out.println("Error 2: " + httpSession.getAttribute("roleUser"));
      return "redirect:/login";
    }
    Long idClient = (Long) httpSession.getAttribute("idUser");
    if (!clientService.existsbyId(idClient)) {
      System.out.println("Error 4: " + clientService.existsbyId(idClient));
      return "redirect:/products";
    }

    model.addAttribute("totalPurchaseCost", productClientCacheService.findTotalAmountByClientId(idClient));
    return "shop/shop-payment.jsp";
  }

  @PostMapping("/add-item")
  public String addItemCache(@RequestParam("idProduct") Long idProduct, HttpSession httpSession) {
    // Validations
    if (((Long) httpSession.getAttribute("idUser")) == null) {
      System.out.println("Error 1: " + httpSession.getAttribute("idUser"));
      return "redirect:/products";
    }
    if (!((httpSession.getAttribute("roleUser")).equals("client"))) {
      System.out.println("Error 2: " + httpSession.getAttribute("roleUser"));
      return "redirect:/products";
    }
    if (!productService.existsbyId(idProduct)) {
      System.out.println("Error 3: " + productService.existsbyId(idProduct));
      return "redirect:/products";
    }
    Long idClient = (Long) httpSession.getAttribute("idUser");
    if (!clientService.existsbyId(idClient)) {
      System.out.println("Error 4: " + clientService.existsbyId(idClient));
      return "redirect:/products";
    }

    // Process
    ProductClientCache productClientCache = new ProductClientCache();
    if (productClientCacheService.existsByClientIdAndProductId(idClient, idProduct)) {
      productClientCache = productClientCacheService.findByClientIdAndProductId(idClient, idProduct).get(0);
      productClientCache.setAmount(productClientCache.getAmount() + 1);
    } else {
      productClientCache.setAmount(1);
    }
    productClientCache.setClient(clientService.findById(idClient));
    productClientCache.setProduct(productService.findById(idProduct));
    productClientCacheService.save(productClientCache);

    return "redirect:/products";
  }

  @PostMapping("/plus")
  public String plusItemCache(@RequestParam("idProduct") Long idProduct, HttpSession httpSession) {
    // Validations
    if (((Long) httpSession.getAttribute("idUser")) == null) {
      System.out.println("Error 1: " + httpSession.getAttribute("idUser"));
      return "redirect:/shop/cart";
    }
    if (!((httpSession.getAttribute("roleUser")).equals("client"))) {
      System.out.println("Error 2: " + httpSession.getAttribute("roleUser"));
      return "redirect:/shop/cart";
    }
    if (!productService.existsbyId(idProduct)) {
      System.out.println("Error 3: " + productService.existsbyId(idProduct));
      return "redirect:/shop/cart";
    }
    Long idClient = (Long) httpSession.getAttribute("idUser");
    if (!clientService.existsbyId(idClient)) {
      System.out.println("Error 4: " + clientService.existsbyId(idClient));
      return "redirect:/shop/cart";
    }

    // Process
    ProductClientCache productClientCache = new ProductClientCache();
    if (productClientCacheService.existsByClientIdAndProductId(idClient, idProduct)) {
      productClientCache = productClientCacheService.findByClientIdAndProductId(idClient, idProduct).get(0);
      productClientCache.setAmount(productClientCache.getAmount() + 1);
    } else {
      productClientCache.setAmount(1);
    }
    productClientCache.setClient(clientService.findById(idClient));
    productClientCache.setProduct(productService.findById(idProduct));
    productClientCacheService.save(productClientCache);

    return "redirect:/shop/cart";
  }

  @PostMapping("/minus")
  public String minusItemCache(@RequestParam("idProduct") Long idProduct, HttpSession httpSession) {
    // Validations
    if (((Long) httpSession.getAttribute("idUser")) == null) {
      System.out.println("Error 1: " + httpSession.getAttribute("idUser"));
      return "redirect:/shop/cart";
    }
    if (!((httpSession.getAttribute("roleUser")).equals("client"))) {
      System.out.println("Error 2: " + httpSession.getAttribute("roleUser"));
      return "redirect:/shop/cart";
    }
    if (!productService.existsbyId(idProduct)) {
      System.out.println("Error 3: " + productService.existsbyId(idProduct));
      return "redirect:/shop/cart";
    }
    Long idClient = (Long) httpSession.getAttribute("idUser");
    if (!clientService.existsbyId(idClient)) {
      System.out.println("Error 4: " + clientService.existsbyId(idClient));
      return "redirect:/shop/cart";
    }

    // Process
    ProductClientCache productClientCache = new ProductClientCache();
    if (productClientCacheService.existsByClientIdAndProductId(idClient, idProduct)) {
      productClientCache = productClientCacheService.findByClientIdAndProductId(idClient, idProduct).get(0);
      productClientCache.setAmount(productClientCache.getAmount() - 1);
      productClientCacheService.save(productClientCache);
    }
    if (productClientCache.getAmount().equals(0)) {
      productClientCacheService.delete(productClientCache);
    }
    return "redirect:/shop/cart";
  }
}
