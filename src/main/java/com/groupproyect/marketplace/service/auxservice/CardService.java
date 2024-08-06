package com.groupproyect.marketplace.service.auxservice;

import com.groupproyect.marketplace.auxclass.Card;

public class CardService {
  public static boolean cardVerify(Card card) {
    if (card != null) {
      return true;
    }
    return false;
  }
}
