package com.groupproyect.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupproyect.marketplace.model.direction.DirectionClient;
import com.groupproyect.marketplace.model.direction.DirectionSeller;
import com.groupproyect.marketplace.model.user.BaseUser;
import com.groupproyect.marketplace.model.user.Client;
import com.groupproyect.marketplace.model.user.Seller;
import com.groupproyect.marketplace.service.cite.DepartmentService;
import com.groupproyect.marketplace.service.cite.DistrictService;
import com.groupproyect.marketplace.service.direction.DirectionClientService;
import com.groupproyect.marketplace.service.direction.DirectionSellerService;
import com.groupproyect.marketplace.service.user.ClientService;
import com.groupproyect.marketplace.service.user.SellerService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class AuthenticationController {
  private final ClientService clientService;
  private final SellerService sellerService;
  private final DepartmentService departmentService;
  private final DistrictService districtService;
  private final DirectionClientService directionClientService;
  private final DirectionSellerService directionSellerService;

  public AuthenticationController(ClientService clientService, SellerService sellerService,
      DepartmentService departmentService, DistrictService districtService,
      DirectionClientService directionClientService, DirectionSellerService directionSellerService) {
    this.clientService = clientService;
    this.sellerService = sellerService;
    this.departmentService = departmentService;
    this.districtService = districtService;
    this.directionClientService = directionClientService;
    this.directionSellerService = directionSellerService;
  }

  @GetMapping({ "/register", "/register/" })
  public String register(@ModelAttribute("user") BaseUser user, Model model) {
    model.addAttribute("departments", departmentService.findAllByOrderByNameAsc());
    model.addAttribute("districts", districtService.findAllByOrderByNameAsc());
    return "authentication/register.jsp";
  }

  @PostMapping("/register")
  public String register(
      @ModelAttribute("user") BaseUser user,
      BindingResult bindingResult,
      @RequestParam("radio-group") String role,
      @RequestParam("direction") String direction,
      @RequestParam("idDistrict") Long idDistrict,
      HttpSession httpSession) {
    if (!(user.getPassword().equals(user.getConfirmPassword()))) {
      FieldError error = new FieldError("confirmPassword", "confirmPassword", "Las contraseñas no coinciden");
      bindingResult.addError(error);
    }
    if ((clientService.existsByEmail(user.getEmail())) || (sellerService.existsByEmail(user.getEmail()))) {
      FieldError error = new FieldError("email", "email", "Este email ya se encuentra registrado.");
      bindingResult.addError(error);
    }
    if (bindingResult.hasErrors()) {
      return "authentication/register.jsp";
    }
    if (role.equals("client")) {
      Client client = clientService.castFromBaseUser(user);
      client = clientService.save(client);

      DirectionClient directionClient = new DirectionClient();
      directionClient.setDistrict(districtService.findById(idDistrict));
      directionClient.setAdress(direction);
      directionClient.setClient(client);
      directionClient = directionClientService.save(directionClient);
      httpSession.setAttribute("idUser", client.getId());
      httpSession.setAttribute("roleUser", "client");

      return "redirect:/";
    } else if (role.equals("seller")) {
      Seller seller = sellerService.castFromBaseUser(user);
      seller = sellerService.save(seller);

      DirectionSeller directionSeller = new DirectionSeller();
      directionSeller.setDistrict(districtService.findById(idDistrict));
      directionSeller.setAdress(direction);
      directionSeller.setSeller(seller);
      directionSeller = directionSellerService.save(directionSeller);
      httpSession.setAttribute("idUser", seller.getId());
      httpSession.setAttribute("roleUser", "seller");

      return "redirect:/stores/new";
    }
    return "redirect:/register";
  }

  @GetMapping({ "/login", "/login/" })
  public String logIn() {
    return "authentication/login.jsp";
  }

  @GetMapping("/logout")
  public String logOut(HttpSession httpSession) {
    httpSession.invalidate();
    return "redirect:/login";
  }

  @PostMapping("/login")
  public String logIn(
      @RequestParam("email") String email,
      @RequestParam("password") String password,
      HttpSession httpSession) {
    if (clientService.checkCredentials(email, password)) {
      httpSession.setAttribute("idUser", clientService.findIdByEmail(email));
      httpSession.setAttribute("roleUser", "client");
      return "redirect:/";
    }
    if (sellerService.checkCredentials(email, password)) {
      httpSession.setAttribute("idUser", sellerService.findIdByEmail(email));
      httpSession.setAttribute("roleUser", "seller");
      return "redirect:/";
    }
    return "redirect:/login";
  }
}
