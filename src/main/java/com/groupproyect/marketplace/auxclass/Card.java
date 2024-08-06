package com.groupproyect.marketplace.auxclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
  private String cardholder;
  private Long cardnumber;
  private Integer expMonth;
  private Integer expYear;
  private Integer cvc;
}
