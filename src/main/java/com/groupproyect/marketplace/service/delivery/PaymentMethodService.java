package com.groupproyect.marketplace.service.delivery;

import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.purchase.PaymentMethod;
import com.groupproyect.marketplace.repository.delivery.PaymentMethodRepository;
import com.groupproyect.marketplace.service.BaseService;

@Service
public class PaymentMethodService  extends BaseService<PaymentMethod> {
    @SuppressWarnings("unused")
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        super(paymentMethodRepository);
        this.paymentMethodRepository = paymentMethodRepository;
    }
}
