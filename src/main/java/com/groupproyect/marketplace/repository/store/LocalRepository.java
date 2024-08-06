package com.groupproyect.marketplace.repository.store;

import java.util.List;

import com.groupproyect.marketplace.model.store.Local;
import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.repository.BaseWithDateRepository;

public interface LocalRepository extends BaseWithDateRepository<Local> {
  List<Local> findByStoreId(Long idStore);

  List<Local> findByStore(Store idStore);
}
