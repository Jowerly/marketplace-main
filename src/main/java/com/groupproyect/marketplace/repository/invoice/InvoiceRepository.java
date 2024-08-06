package com.groupproyect.marketplace.repository.invoice;



import com.groupproyect.marketplace.model.purchase.Invoice;
import com.groupproyect.marketplace.repository.BaseWithDateRepository;

public interface InvoiceRepository extends BaseWithDateRepository<Invoice> {

    Invoice findByOrderId(Long OrderId);
} 
