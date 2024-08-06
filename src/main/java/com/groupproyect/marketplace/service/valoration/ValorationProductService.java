package com.groupproyect.marketplace.service.valoration;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.valoration.ValorationProduct;
import com.groupproyect.marketplace.repository.valoration.ValorationProductRepository;

@Service
public class ValorationProductService extends BaseValorationService<ValorationProduct> {
  private final ValorationProductRepository valorationProductRepository;

  public ValorationProductService(ValorationProductRepository valorationProductRepository) {
    super(valorationProductRepository);
    this.valorationProductRepository = valorationProductRepository;
  }

  public List<ValorationProduct> findByProductIdOrderByCreatedAtDesc(Long idProduct) {
    return valorationProductRepository.findByProductIdOrderByCreatedAtDesc(idProduct);
  }
}
