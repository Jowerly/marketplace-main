package com.groupproyect.marketplace.repository.membership;

import java.util.List;

import com.groupproyect.marketplace.model.monetization.MembershipSeller;
import com.groupproyect.marketplace.model.user.Seller;
import com.groupproyect.marketplace.repository.BaseWithDateRepository;

public interface MembershipSellerRepository extends BaseWithDateRepository<MembershipSeller> {
  List<MembershipSeller> findBySeller(Seller seller);
  
  List<MembershipSeller> findBySellerId(Long idSeller);

  boolean existsBySellerId(Long idSeller);

  boolean existsBySeller(Seller seller);

  List<MembershipSeller> findBySellerIdOrderByExpirationDesc(Long seller);
}
