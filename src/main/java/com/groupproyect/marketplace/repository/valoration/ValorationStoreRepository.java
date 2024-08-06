package com.groupproyect.marketplace.repository.valoration;

import java.util.List;

import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.model.valoration.ValorationStore;

public interface ValorationStoreRepository extends BaseValorationRepository<ValorationStore> {
  List<ValorationStore> findByStoreId(Long idStore);

  List<ValorationStore> findByStore(Store store);

  List<ValorationStore> findByStoreIdOrderByCreatedAtDesc(Long idStore);

  List<ValorationStore> findByStoreOrderByCreatedAtDesc(Store store);
}
