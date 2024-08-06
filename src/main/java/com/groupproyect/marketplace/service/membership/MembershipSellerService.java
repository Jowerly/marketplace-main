package com.groupproyect.marketplace.service.membership;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.monetization.MembershipSeller;
import com.groupproyect.marketplace.model.user.Seller;
import com.groupproyect.marketplace.repository.membership.MembershipSellerRepository;
import com.groupproyect.marketplace.service.BaseWithDateService;

@Service
public class MembershipSellerService extends BaseWithDateService<MembershipSeller> {
  private final MembershipSellerRepository membershipSellerRepository;

  public MembershipSellerService(MembershipSellerRepository membershipSellerRepository) {
    super(membershipSellerRepository);
    this.membershipSellerRepository = membershipSellerRepository;
  }

  public List<MembershipSeller> findBySellerId(Long idSeller) {
    return membershipSellerRepository.findBySellerId(idSeller);
  }

  public List<MembershipSeller> findBySeller(Seller seller) {
    return membershipSellerRepository.findBySeller(seller);
  }

  public boolean existsBySeller(Seller seller) {
    if (seller == null) {
      return false;
    }
    return membershipSellerRepository.existsBySeller(seller);
  }

  public boolean existsBySellerId(Long idSeller) {
    if (idSeller == null) {
      return false;
    }
    return membershipSellerRepository.existsBySellerId(idSeller);
  }

  public LocalDateTime findMaxExpirationBySellerId(Long idSeller) {
    MembershipSeller membershipSeller = (membershipSellerRepository.findBySellerIdOrderByExpirationDesc(idSeller)).get(0);
    return membershipSeller.getExpiration();
  }
}
