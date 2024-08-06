package com.groupproyect.marketplace.model.monetization;

import java.time.LocalDateTime;

import com.groupproyect.marketplace.model.BaseModelWithDate;

import com.groupproyect.marketplace.model.user.Seller;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "memberships_sellers")
@Getter
@Setter
public class MembershipSeller extends BaseModelWithDate {
  private LocalDateTime activation;
  private LocalDateTime expiration;

  // Table with Foreign Key
  // Table: sellers FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="seller_id")
  private Seller seller;

  // Table with Foreign Key
  // Table: memberships FK
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="membership_id")
  private Membership membership;
}
