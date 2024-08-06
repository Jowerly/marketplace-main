package com.groupproyect.marketplace.model.valoration;

import com.groupproyect.marketplace.model.BaseModelWithDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseValoration extends BaseModelWithDate {
  private Integer stars;
  private String review;
}
