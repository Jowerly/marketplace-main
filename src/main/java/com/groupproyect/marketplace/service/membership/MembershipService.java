package com.groupproyect.marketplace.service.membership;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.monetization.Membership;
import com.groupproyect.marketplace.repository.membership.MembershipRepository;
import com.groupproyect.marketplace.service.BaseService;

@Service
public class MembershipService extends BaseService<Membership> {
  private final MembershipRepository membershipRepository;

  public MembershipService(MembershipRepository membershipRepository) {
    super(membershipRepository);
    this.membershipRepository = membershipRepository;
  }

  public List<Membership> findAllOrderByPriceAsc() {
    return membershipRepository.findAllByOrderByPriceAsc();
  }
}
