package com.groupproyect.marketplace.model.direction;

import com.groupproyect.marketplace.model.BaseModelWithDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseDirection extends BaseModelWithDate {
  private String adress;
}
