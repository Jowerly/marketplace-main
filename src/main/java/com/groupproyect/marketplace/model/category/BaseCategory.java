package com.groupproyect.marketplace.model.category;

import com.groupproyect.marketplace.model.BaseModel;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseCategory extends BaseModel {
  private String name;
}