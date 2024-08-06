<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Order Details</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    :root {
      --colorbg: #191724;
      --colorfg: #e0def4;
      --color1: #eb6f92;
      --color2: #9ccfd8;
      --color3: #f6c177;
      --colormain1: #ebbcba;
    }

    body {
      background-color: var(--colorbg);
      color: var(--colorfg);
    }

    .container {
      background-color: var(--colorbg);
      padding: 20px;
      border-radius: 8px;
    }

    h2, h3 {
      color: var(--colormain1);
    }

    p {
      margin: 10px 0;
    }

    .product-item {
      border: 2px solid var(--colorfg);
      padding: 10px;
      margin-bottom: 10px;
      list-style-type: none;
    }

    .scrollable-products {
      max-height: 400px; /* Ajusta la altura máxima según tus necesidades */
      overflow-y: scroll;
    }

    .btn-primary {
      background-color: var(--color3);
      border: none;
    }

    .btn-primary:hover {
      background-color: var(--color3);
      border: none;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Order Details</h2>
  <p><strong>ID:</strong> ${order.id}</p>
  <p><strong>Date:</strong> ${order.createdAt}</p>
  <p><strong>Status:</strong> ${order.deliveryStatus.name}</p>
  <h3>Products</h3>
  <div class="scrollable-products">
    <ul>
      <c:forEach var="product" items="${order.products}">
        <li class="product-item">
          <span>Nombre del Producto: <c:out value="${product.name}"/></span><br/>
          <span>Precio: <c:out value="${product.price}"/></span><br/>
          <span>Tienda: <c:out value="${product.store.name}"/></span><br/>
          <span>Vendedor Asociado: <c:out value="${product.store.seller.firstName} ${product.store.seller.lastName}"/></span>
        </li>
      </c:forEach>
    </ul>
  </div>
  <a href="${pageContext.request.contextPath}/orders" class="btn btn-primary">Back to Orders</a>

    <form:form action="/invoices/${order.id}" method="post" modelAttribute="Invoice" >

    <form:input type="hidden" path="order" value="${order.id}" />

    <form:input type="hidden" path="deliveryMethod" value="${idDelivery}"  />
    
    <form:input type="hidden" path="paymentMethod" value="${idPayMet}"  />
    
    <form:input type="hidden"  path="iva" value="${invoice.iva}" />

    <button class="btn btn-primary my-3"> FACTURA </button>
    </form:form>


</div>
</body>
</html>
