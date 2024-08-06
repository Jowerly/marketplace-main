package com.groupproyect.marketplace.repository.membership;

import java.util.List;

import com.groupproyect.marketplace.model.monetization.Membership;
import com.groupproyect.marketplace.repository.BaseRepository;

public interface MembershipRepository extends BaseRepository<Membership> {
  List<Membership> findAllByOrderByPriceAsc();
}
