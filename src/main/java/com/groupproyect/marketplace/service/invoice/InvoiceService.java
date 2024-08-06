package com.groupproyect.marketplace.service.invoice;


import org.springframework.stereotype.Service;

import com.groupproyect.marketplace.model.purchase.Invoice;
import com.groupproyect.marketplace.repository.invoice.InvoiceRepository;
import com.groupproyect.marketplace.service.BaseWithDateService;

@Service
public class InvoiceService extends BaseWithDateService<Invoice> {
    
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
    super(invoiceRepository);
    this.invoiceRepository = invoiceRepository;
    }

    public Invoice findByOrderId(Long OrderId) {
    return invoiceRepository.findByOrderId(OrderId);
    }
}
