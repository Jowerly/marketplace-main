package com.groupproyect.marketplace.repository.store;

import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.model.user.Seller;
import com.groupproyect.marketplace.repository.BaseWithDateRepository;

public interface StoreRepository extends BaseWithDateRepository<Store> {
  Store findBySeller(Seller seller);

  Store findBySellerId(Long idSeller);
}
