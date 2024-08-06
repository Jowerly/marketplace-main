package com.groupproyect.marketplace.model.cite;

import com.groupproyect.marketplace.model.BaseModel;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseCite extends BaseModel {
  private String name;
}
