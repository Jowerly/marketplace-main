package com.groupproyect.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupproyect.marketplace.model.delivery.DeliveryMethod;
import com.groupproyect.marketplace.model.order.Order;
import com.groupproyect.marketplace.model.purchase.Invoice;
import com.groupproyect.marketplace.model.purchase.PaymentMethod;
import com.groupproyect.marketplace.service.cache.ProductClientCacheService;
import com.groupproyect.marketplace.service.delivery.DeliveryMethodService;
import com.groupproyect.marketplace.service.delivery.PaymentMethodService;
import com.groupproyect.marketplace.service.direction.DirectionClientService;
import com.groupproyect.marketplace.service.invoice.InvoiceService;
import com.groupproyect.marketplace.service.order.OrderService;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

  private final InvoiceService invoiceService;
  private final OrderService orderService;
  private final DirectionClientService directionClientService;
  private final ProductClientCacheService productClientCacheService;

  private final DeliveryMethodService deliveryMethodService;
  private final PaymentMethodService paymentMethodService;

  public InvoiceController(InvoiceService invoiceService,
      OrderService orderService, DirectionClientService directionClientService,
      ProductClientCacheService productClientCacheService,
      DeliveryMethodService deliveryMethodService, PaymentMethodService paymentMethodService) {
    this.invoiceService = invoiceService;
    this.orderService = orderService;
    this.directionClientService = directionClientService;
    this.productClientCacheService = productClientCacheService;
    this.deliveryMethodService = deliveryMethodService;
    this.paymentMethodService = paymentMethodService;
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public String invoiceByOrder(@PathVariable("id") Long id,
      Model model, @ModelAttribute("order") Order order,
      @ModelAttribute("Invoice") Invoice invoice,
      @ModelAttribute("deliveryMethod") DeliveryMethod deliveryMethod,
      @ModelAttribute("paymentMethod") PaymentMethod paymentMethod) {

    order = orderService.findById(id);

    model.addAttribute("order", order);
    model.addAttribute("direction", directionClientService.findById(id));
    model.addAttribute("productservice",
        productClientCacheService.findByClientId(orderService.findById(id).getClient().getId()));
    model.addAttribute("date", orderService.findById(id).getCreatedAt().toString().substring(0, 10));

    /* productClientCacheService.findByClientIdAndProductId */
    model.addAttribute("cantidad", productClientCacheService.findAll());
    return "invoice.jsp";
  }

  @PostMapping({ "/{id}", "/{id}/" })
  public String newinvoice(@PathVariable("id") Long id,
      Model model, @ModelAttribute("Invoice") Invoice invoice) {

    Order order = orderService.findById(id);

    if (invoiceService.findByOrderId(id) != null) {
      return "redirect:/invoices/" + order.getId();
    }

    invoice = new Invoice();
    DeliveryMethod deliveryMethod = new DeliveryMethod();
    PaymentMethod paymentMethod = new PaymentMethod();

    deliveryMethod.setName("ContraEntrega");
    paymentMethod.setName("Tarjeta");

    invoice.setDeliveryMethod(deliveryMethod);
    invoice.setOrder(order);
    invoice.setPaymentMethod(paymentMethod);

    deliveryMethodService.save(deliveryMethod);
    paymentMethodService.save(paymentMethod);
    invoiceService.save(invoice);

    return "redirect:/invoices/" + order.getId();
  }
}
