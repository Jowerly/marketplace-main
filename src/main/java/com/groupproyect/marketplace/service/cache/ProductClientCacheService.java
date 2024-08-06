package com.groupproyect.marketplace.service.cache;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.cache.ProductClientCache;
import com.groupproyect.marketplace.model.user.Client;
import com.groupproyect.marketplace.repository.cache.ProductClientCacheRepository;
import com.groupproyect.marketplace.service.BaseWithDateService;

@Service
public class ProductClientCacheService extends BaseWithDateService<ProductClientCache> {
  private final ProductClientCacheRepository productClientCacheRepository;

  public ProductClientCacheService(ProductClientCacheRepository productClientCacheRepository) {
    super(productClientCacheRepository);
    this.productClientCacheRepository = productClientCacheRepository;
  }

  public List<ProductClientCache> findByClientId(Long idClient) {
    return productClientCacheRepository.findByClientId(idClient);
  }

  public List<ProductClientCache> findByClient(Client client) {
    return productClientCacheRepository.findByClient(client);
  }

  public List<ProductClientCache> findByClientIdAndProductId(Long idClient, Long idProduct) {
    return productClientCacheRepository.findByClientIdAndProductId(idClient, idProduct);
  }

  public boolean existsByClientId(Long idClient) {
    return productClientCacheRepository.existsByClientId(idClient);
  }

  public boolean existsByClientIdAndProductId(Long idClient, Long idProduct) {
    return productClientCacheRepository.existsByClientIdAndProductId(idClient, idProduct);
  }

  public boolean existsByClient(Client client) {
    return productClientCacheRepository.existsByClient(client);
  }

  public Double findTotalAmountByClientId(Long idClient) {
    return productClientCacheRepository.findTotalAmountByClientId(idClient);
  }
}
