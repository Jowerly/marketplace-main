package com.groupproyect.marketplace.service.user;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.store.Store;
import com.groupproyect.marketplace.model.user.BaseUser;
import com.groupproyect.marketplace.model.user.Seller;
import com.groupproyect.marketplace.repository.user.SellerRepository;

@Service
public class SellerService extends BaseUserService<Seller> {
  private final SellerRepository sellerRepository;

  public SellerService(SellerRepository sellerRepository) {
    super(sellerRepository);
    this.sellerRepository = sellerRepository;
  }

  public Seller findByStoreId(Long id) {
    return sellerRepository.findByStoreId(id);
  }

  public Seller findByStore(Store store) {
    return sellerRepository.findByStore(store);
  }

  public Seller castFromBaseUser(BaseUser baseUser) {
    Seller seller = new Seller();
    seller.setFirstName(baseUser.getFirstName());
    seller.setLastName(baseUser.getLastName());
    seller.setEmail(baseUser.getEmail());
    seller.setTelephoneNumber(baseUser.getTelephoneNumber());
    seller.setNumberDocumentIdentity(baseUser.getNumberDocumentIdentity());
    seller.setPassword(baseUser.getPassword());
    return seller;
  }
}