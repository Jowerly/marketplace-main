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

import com.groupproyect.marketplace.model.direction.DirectionLocal;
import com.groupproyect.marketplace.model.store.Local;
import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.model.user.Seller;
import com.groupproyect.marketplace.model.valoration.ValorationStore;
import com.groupproyect.marketplace.service.category.CategoryOneService;
import com.groupproyect.marketplace.service.cite.DepartmentService;
import com.groupproyect.marketplace.service.cite.DistrictService;
import com.groupproyect.marketplace.service.direction.DirectionLocalService;
import com.groupproyect.marketplace.service.product.ProductService;
import com.groupproyect.marketplace.service.store.LocalService;
import com.groupproyect.marketplace.service.store.StoreService;
import com.groupproyect.marketplace.service.user.SellerService;
import com.groupproyect.marketplace.service.valoration.ValorationStoreService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/stores")
public class StoreController {
  private final SellerService sellerService;
  private final StoreService storeService;
  private final DepartmentService departmentService;
  private final DistrictService districtService;
  private final CategoryOneService categoryOneService;
  private final DirectionLocalService directionLocalService;
  private final LocalService localService;
  private final ProductService productService;
  private final ValorationStoreService valorationStoreService;

  public StoreController(StoreService storeService, SellerService sellerService, DepartmentService departmentService,
      DistrictService districtService, CategoryOneService categoryOneService,
      DirectionLocalService directionLocalService, LocalService localService, ProductService productService,
      ValorationStoreService valorationStoreService) {
    this.storeService = storeService;
    this.sellerService = sellerService;
    this.departmentService = departmentService;
    this.districtService = districtService;
    this.categoryOneService = categoryOneService;
    this.directionLocalService = directionLocalService;
    this.localService = localService;
    this.productService = productService;
    this.valorationStoreService = valorationStoreService;
  }

  @GetMapping({ "/new", "/new/" })
  public String newStore(@ModelAttribute("store") Store store, Model model, HttpSession httpSession) {
    Long idUser = ((Long) httpSession.getAttribute("idUser"));
    model.addAttribute("seller", sellerService.findById(idUser));
    model.addAttribute("store", new Store());
    model.addAttribute("departments", departmentService.findAllByOrderByNameAsc());
    model.addAttribute("districts", districtService.findAll());
    model.addAttribute("categoriesOnes", categoryOneService.findAll());
    model.addAttribute("locales", localService.findAll());
    return "store/store-new.jsp";
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public String showStore(@PathVariable("id") Long id, Model model,
      @ModelAttribute("valorationStore") ValorationStore valorationStore) {
    model.addAttribute("store", storeService.findById(id));
    model.addAttribute("seller", sellerService.findByStoreId(id));
    model.addAttribute("products", productService.findByStoreId(id));
    model.addAttribute("valorationsStore", valorationStoreService.findByStoreIdOrderByCreatedAtDesc(id));
    model.addAttribute("locales", localService.findByStoreId(id));
    return "store/store-show.jsp";
  }

  @PostMapping({ "/new" })
  public String createStore(@Valid @ModelAttribute("store") Store store, BindingResult result, HttpSession httpSession,
      RedirectAttributes redirectAttributes, @RequestParam("password") String password,
      @RequestParam("direction") String direction, @RequestParam("idDistrict") Long idDistrict,
      @RequestParam("categoryOne") Long idCategoryOne) {
    if (((Long) httpSession.getAttribute("idUser")) == null) {
      redirectAttributes.addFlashAttribute("userError", "No estas logeado.");
      return "redirect:/stores/new";
    }
    if (((String) httpSession.getAttribute("roleUser")) != "seller") {
      redirectAttributes.addFlashAttribute("roleError",
          "Solo los vendedores pueden registar su tienda, puedes crear otra cuenta.");
      return "redirect:/stores/new";
    }
    Long idSeller = ((Long) httpSession.getAttribute("idUser"));
    if (!sellerService.checkCredentials(idSeller, password)) {
      redirectAttributes.addFlashAttribute("passwordError", "La contraseña es invalida.");
      return "redirect:/stores/new";
    }
    if (result.hasErrors()) {
      return "redirect:/login";
    }
    store = storeService.save(store);
    Seller seller = sellerService.findById(idSeller);
    Local local = new Local();
    DirectionLocal directionLocal = new DirectionLocal();
    Long idStore = store.getId();
    store.setCategoryOne(categoryOneService.findById(idCategoryOne));
    seller.setStore(store);
    local.setStore(store);
    seller = sellerService.save(seller);
    local = localService.save(local);
    directionLocal.setLocal(local);
    directionLocal.setAdress(direction);
    directionLocal.setDistrict(districtService.findById(idDistrict));
    directionLocal = directionLocalService.save(directionLocal);
    return "redirect:/stores/" + idStore;
  }
}
