package com.groupproyect.marketplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupproyect.marketplace.model.purchase.Invoice;
import com.groupproyect.marketplace.auxclass.Card;
import com.groupproyect.marketplace.model.cache.ProductClientCache;
import com.groupproyect.marketplace.model.order.Order;
import com.groupproyect.marketplace.model.order.OrderProduct;
import com.groupproyect.marketplace.model.product.Product;
import com.groupproyect.marketplace.model.user.Client;
import com.groupproyect.marketplace.service.auxservice.CardService;
import com.groupproyect.marketplace.service.cache.ProductClientCacheService;
import com.groupproyect.marketplace.service.delivery.DeliveryStatusService;
import com.groupproyect.marketplace.service.order.OrderProductService;
import com.groupproyect.marketplace.service.order.OrderService;
import com.groupproyect.marketplace.service.user.ClientService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/orders")
public class OrderController {
  private final OrderService orderService;
  private final OrderProductService orderProductService;
  private final ClientService clientService;
  private final ProductClientCacheService productClientCacheService;
  private final DeliveryStatusService deliveryStatusService;

  public OrderController(OrderService orderService, OrderProductService orderProductService,
      ClientService clientService, ProductClientCacheService productClientCacheService,
      DeliveryStatusService deliveryStatusService) {
    this.orderService = orderService;
    this.clientService = clientService;
    this.productClientCacheService = productClientCacheService;
    this.orderProductService = orderProductService;
    this.deliveryStatusService = deliveryStatusService;
  }

  @GetMapping({ "", "/" })
  public String getUserOrders(Model model, HttpSession httpSession) {
    // Validations
    if (((Long) httpSession.getAttribute("idUser")) == null) {
      System.out.println("Error 1: " + httpSession.getAttribute("idUser"));
      return "redirect:/";
    }
    if (!((httpSession.getAttribute("roleUser")).equals("client"))) {
      System.out.println("Error 2: " + httpSession.getAttribute("roleUser"));
      return "redirect:/";
    }
    Long idClient = (Long) httpSession.getAttribute("idUser");

    List<Order> orders = orderService.findByClientId(idClient);
    model.addAttribute("orders", orders);
    return "order/orders.jsp";
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public String getOrderDetails(@PathVariable("id") Long id, Model model, @ModelAttribute("Invoice") Invoice invoice) {
    Order order = orderService.findById(id);
    model.addAttribute("order", order);
    return "order/order-show.jsp";
  }

  @PostMapping("/new")
  public String createOrder(HttpSession httpSession, @ModelAttribute("card") Card card) {
    if (!CardService.cardVerify(card)) {
      return "bad-card.jsp";
    }
    // Validations
    if (((Long) httpSession.getAttribute("idUser")) == null) {
      System.out.println("Error 1: " + httpSession.getAttribute("idUser"));
      return "redirect:/shop/payment";
    }
    if (!((httpSession.getAttribute("roleUser")).equals("client"))) {
      System.out.println("Error 2: " + httpSession.getAttribute("roleUser"));
      return "redirect:/shop/payment";
    }

    Long idClient = (Long) httpSession.getAttribute("idUser");
    Client client = clientService.findById(idClient);

    List<ProductClientCache> productClientCaches = new ArrayList<ProductClientCache>();

    if (productClientCacheService.existsByClientId(idClient)) {
      productClientCaches = productClientCacheService.findByClientId(idClient);
    }

    Order order = new Order();
    order.setClient(client);
    order.setDeliveryStatus(deliveryStatusService.findById(1L));
    order = orderService.save(order);

    for (ProductClientCache productClientCache : productClientCaches) {
      OrderProduct orderProduct = new OrderProduct();
      Product product = productClientCache.getProduct();

      orderProduct.setOrder(order);
      orderProduct.setProduct(product);
      orderProduct.setAmount(productClientCache.getAmount());
      orderProduct.setPrice(product.getPrice());
      orderProductService.save(orderProduct);

      productClientCacheService.delete(productClientCache);
    }

    return "process-confirmation.jsp";
  }
}
