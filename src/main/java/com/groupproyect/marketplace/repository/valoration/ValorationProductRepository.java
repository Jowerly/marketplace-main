package com.groupproyect.marketplace.repository.valoration;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.groupproyect.marketplace.model.valoration.ValorationProduct;

@Repository
public interface ValorationProductRepository extends BaseValorationRepository<ValorationProduct> {
  List<ValorationProduct> findByProductIdOrderByCreatedAtDesc(Long idProduct);
}
