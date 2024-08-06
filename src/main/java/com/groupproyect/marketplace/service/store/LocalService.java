package com.groupproyect.marketplace.service.store;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.store.Local;
import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.repository.store.LocalRepository;
import com.groupproyect.marketplace.service.BaseWithDateService;

@Service
public class LocalService extends BaseWithDateService<Local> {
  private final LocalRepository localRepository;

  public LocalService(LocalRepository localRepository) {
    super(localRepository);
    this.localRepository = localRepository;
  }

  public List<Local> findByStoreId(Long id) {
    return localRepository.findByStoreId(id);
  }

  public List<Local> findByStore(Store store) {
    return localRepository.findByStore(store);
  }
}
