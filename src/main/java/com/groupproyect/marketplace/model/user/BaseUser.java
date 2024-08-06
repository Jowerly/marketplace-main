package com.groupproyect.marketplace.model.user;

import com.groupproyect.marketplace.model.BaseModelWithDate;
import com.groupproyect.marketplace.service.user.IAuxBaseUser;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseUser extends BaseModelWithDate implements IAuxBaseUser {
  private String firstName;
  private String lastName;
  private String email;
  private String telephoneNumber;
  private String password;
  private String numberDocumentIdentity;
  private Boolean isEnable;

  @Transient
  private String confirmPassword;

  @PrePersist
  public void setEnable() {
    this.isEnable = true;
  }
}
