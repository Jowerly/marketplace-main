package com.groupproyect.marketplace.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupproyect.marketplace.model.category.CategoryOne;
import com.groupproyect.marketplace.model.category.CategoryTwo;
import com.groupproyect.marketplace.service.category.CategoryOneService;
import com.groupproyect.marketplace.service.category.CategoryTwoService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
  private final CategoryOneService categoryOneService;
  private final CategoryTwoService categoryTwoService;

  public CategoryController(CategoryOneService categoryOneService, CategoryTwoService categoryTwoService) {
    this.categoryOneService = categoryOneService;
    this.categoryTwoService = categoryTwoService;
  }

  @GetMapping({ "", "/" })
  public String getCategories(Model model) {
    List<CategoryOne> categoriesOne = categoryOneService.findAll().stream().limit(10).collect(Collectors.toList());

    // Mapear categorías de nivel uno a sus subcategorías, limitando a 10
    Map<Long, List<CategoryTwo>> categoryTwoMap = categoriesOne.stream()
        .collect(Collectors.toMap(
            CategoryOne::getId,
            categoryOne -> categoryTwoService.findByCategoryOneId(categoryOne.getId())
                .stream()
                .limit(10)
                .collect(Collectors.toList())));

    model.addAttribute("categoriesOne", categoriesOne);
    model.addAttribute("categoryTwoMap", categoryTwoMap);

    return "categories/categories.jsp";
  }
}