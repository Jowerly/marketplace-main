package com.groupproyect.marketplace.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupproyect.marketplace.model.category.CategoryOne;
import com.groupproyect.marketplace.model.category.CategoryThree;
import com.groupproyect.marketplace.model.category.CategoryTwo;
import com.groupproyect.marketplace.service.category.CategoryOneService;
import com.groupproyect.marketplace.service.category.CategoryThreeService;
import com.groupproyect.marketplace.service.category.CategoryTwoService;

@RestController
@RequestMapping("/api/categories")
public class CategoryApi {
  private final CategoryOneService categoryOneService;
  private final CategoryTwoService categoryTwoService;
  private final CategoryThreeService categoryThreeService;

  public CategoryApi(CategoryOneService categoryOneService, CategoryTwoService categoryTwoService,
      CategoryThreeService categoryThreeService) {
    this.categoryOneService = categoryOneService;
    this.categoryTwoService = categoryTwoService;
    this.categoryThreeService = categoryThreeService;
  }

  @GetMapping({ "/ones", "/ones/", "/ones", "/ones/" })
  public List<CategoryOne> findAllCategoriesOnes() {
    return categoryOneService.findAll();
  }

  @GetMapping({ "/twos", "/twos/", "/twos", "/twos/" })
  public List<CategoryTwo> findAllCategoriesTwos() {
    return categoryTwoService.findAll();
  }

  @GetMapping({ "/threes", "/threes/", "/three", "/three/" })
  public List<CategoryThree> findAllCategoriesThrees() {
    return categoryThreeService.findAll();
  }
}
