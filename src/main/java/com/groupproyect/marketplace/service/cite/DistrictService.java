package com.groupproyect.marketplace.service.cite;

import com.groupproyect.marketplace.model.cite.District;
import com.groupproyect.marketplace.repository.cite.DistrictRepository;
import org.springframework.stereotype.Service;

@Service
public class DistrictService extends BaseCiteService<District> {
  @SuppressWarnings("unused")
  private DistrictRepository districtRepository;

  public DistrictService(DistrictRepository districtRepository) {
    super(districtRepository);
    this.districtRepository = districtRepository;
  }
}
