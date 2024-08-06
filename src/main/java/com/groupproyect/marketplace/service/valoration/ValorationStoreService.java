package com.groupproyect.marketplace.service.valoration;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.model.valoration.ValorationStore;
import com.groupproyect.marketplace.repository.valoration.ValorationStoreRepository;

@Service
public class ValorationStoreService extends BaseValorationService<ValorationStore> {
  private final ValorationStoreRepository valorationStoreRepository;

  public ValorationStoreService(ValorationStoreRepository valorationStoreRepository) {
    super(valorationStoreRepository);
    this.valorationStoreRepository = valorationStoreRepository;
  }

  public List<ValorationStore> findByStoreId(Long id) {
    return valorationStoreRepository.findByStoreId(id);
  }

  public List<ValorationStore> findByStore(Store store) {
    return valorationStoreRepository.findByStore(store);
  }

  public List<ValorationStore> findByStoreIdOrderByCreatedAtDesc(Long idStore) {
    return valorationStoreRepository.findByStoreIdOrderByCreatedAtDesc(idStore);
  }

  public List<ValorationStore> findByStoreOrderByCreatedAtDesc(Store store) {
    return valorationStoreRepository.findByStoreOrderByCreatedAtDesc(store);
  }
}
