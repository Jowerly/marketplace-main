package com.groupproyect.marketplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupproyect.marketplace.model.category.CategoryThree;
import com.groupproyect.marketplace.model.category.CategoryTwo;
import com.groupproyect.marketplace.model.product.Product;
import com.groupproyect.marketplace.service.category.CategoryOneService;
import com.groupproyect.marketplace.service.category.CategoryThreeService;
import com.groupproyect.marketplace.service.category.CategoryTwoService;
import com.groupproyect.marketplace.service.product.ProductService;

@Controller
@RequestMapping("/category")
public class CategoryController {
  private final ProductService productService;
  private final CategoryOneService categoryOneService;
  private final CategoryTwoService categoryTwoService;
  private final CategoryThreeService categoryThreeService;

  public CategoryController(ProductService productService, CategoryOneService categoryOneService, CategoryTwoService categoryTwoService, CategoryThreeService categoryThreeService) {
    this.productService = productService;
    this.categoryOneService = categoryOneService;
    this.categoryTwoService = categoryTwoService;
    this.categoryThreeService = categoryThreeService;
  }

  @GetMapping({"1/{idCategoryOne}", "1/{idCategoryOne}/"})
  public String showOneProducts(@PathVariable("idCategoryOne") Long idCategoryOne, Model model) {
    List<Product> products = new ArrayList<Product>();
    List<CategoryTwo> categoriesTwos = categoryTwoService.findByCategoryOneId(idCategoryOne);
    List<CategoryThree> categoriesThrees = new ArrayList<CategoryThree>();
    for (CategoryTwo categoryTwo : categoriesTwos) {
      categoriesThrees = categoryThreeService.findByCategoryTwoId(categoryTwo.getId());
      for (CategoryThree categoryThree : categoriesThrees) {
        products.addAll(productService.findByCategoryThreeId(categoryThree.getId()));
      }
    }
    model.addAttribute("products", products);
    model.addAttribute("category", categoryOneService.findById(idCategoryOne));
    model.addAttribute("categoriesOne", categoryOneService.findAll());
    return "category/category-show-products.jsp";
  }

  @GetMapping({"2/{idCategoryTwo}", "2/{idCategoryTwo}/"})
  public String showTwoProducts(@PathVariable("idCategoryTwo") Long idCategoryTwo, Model model) {
    List<Product> products = new ArrayList<Product>();
    List<CategoryThree> categoriesThrees = categoryThreeService.findByCategoryTwoId(idCategoryTwo);
    for (CategoryThree categoryThree : categoriesThrees) {
      products.addAll(productService.findByCategoryThreeId(categoryThree.getId()));
    }
    model.addAttribute("products", products);
    model.addAttribute("category", categoryTwoService.findById(idCategoryTwo));
    model.addAttribute("categoriesOne", categoryOneService.findAll());
    return "category/category-show-products.jsp";
  }

  @GetMapping({"3/{idCategoryThree}", "3/{idCategoryThree}/"})
  public String showThreeProducts(@PathVariable("idCategoryThree") Long idCategoryThree, Model model) {
    List<Product> products = productService.findByCategoryThreeId(idCategoryThree);
    model.addAttribute("products", products);
    model.addAttribute("category", categoryThreeService.findById(idCategoryThree));
    model.addAttribute("categoriesOne", categoryOneService.findAll());

    return "category/category-show-products.jsp";
  }
}
