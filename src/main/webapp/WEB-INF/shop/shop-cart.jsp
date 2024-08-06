<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Carrito de Compras</title>
  <link rel="stylesheet" href="/styles/main.css">
  <link rel="stylesheet" href="/styles/shop-cart.css">
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
  <div class="container-main">
    <div class="container-left">
      <div class="container-info subcontainer-2">
        <h1 class="title-1"><span class="icon"><i class='bx bxs-cart'></i></span> Mi Carrito</h1>
        <span class="data">
          <span class="data-info"></span>
        </span>
      </div>
      <div class="container-cart-items subcontainer-2">
        <c:forEach items="${productsClientCache}" var="productClientCache">
          <div class="cart-item">
            <c:if test="${empty productClientCache.product.linkImage}">
              <div class="item-img" style="background-image: url('https://img.freepik.com/free-vector/illustration-gallery-icon_53876-27002.jpg');">
            </c:if>
            <c:if test="${not empty productClientCache.product.linkImage}">
              <div class="item-img" style="background-image: url('${productClientCache.product.linkImage}');">
            </c:if>
            </div>
            <div class="item-info">
              <div class="info-top">
                <span class="data-info"><c:out value="${productClientCache.product.store.name}"/></span>
                <h1 class="title-3"><c:out value="${productClientCache.product.name}"/></h1>
              </div>
              <div class="info-bot">
                <div class="mini-data"><c:out value="${productClientCache.product.categoryThree.name}"/></div>
                <div class="amount-price">
                  <label path="stars" class="form-pt  mini-data">Cantidad: </label>
                  <form action="/shop/minus" method="post" class="form-sign">
                    <input type="hidden" name="idProduct" value="${productClientCache.product.id}">
                    <button class="icon-sign-btn"><i class='bx bxs-minus-square'></i></button>
                  </form>
                  <div class="number mini-data"> <c:out value="${productClientCache.amount}"/> </div>
                  <c:set var="productPrice" value="${productClientCache.product.price * productClientCache.amount}" />
                  <form action="/shop/plus" method="post" class="form-sign">
                    <input type="hidden" name="idProduct" value="${productClientCache.product.id}">
                    <button class="icon-sign-btn"><i class='bx bxs-plus-square'></i></button>
                  </form>
                  <h3 class="title-3 mini-data">
                    <fmt:formatNumber value="${productPrice}" type="number" maxFractionDigits="2" /> COP
                  </h3>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
      <div class="submit-form subcontainer-2">
        <form action="/shop/payment">
          <input type="hidden" name="listProducts" id="listProducts" />
          <button>Continuar Con la Compra</button>
        </form>
      </div>
    </div>
    <div class="container-right">
      <div class="container-msc subcontainer-2">
        <h1 class="title-2">Miscelanea</h1>
      </div>
      <div class="container-items subcontainer-2">
        <h1 class="title-2">Productos Recomendados</h1>
        <c:if test="${empty products}">
          <span class="data-info text-danger">Aún no tienes productos añadidos!</span>
          <a href="/products/new" class="data-info text-danger">Crear Aquí</a><br>
        </c:if>
        <c:if test="${not empty products}">
          <c:forEach items="${products}" var="product">
            <div class="cart-item cart-item-product">
                <c:if test="${empty product.linkImage}">
                  <div class="item-img" style="background-image: url('https://img.freepik.com/free-vector/illustration-gallery-icon_53876-27002.jpg');">
                </c:if>
                <c:if test="${not empty product.linkImage}">
                  <div class="item-img" style="background-image: url('${product.linkImage}');">
                </c:if>
              </div>
              <div class="item-info">
                <div class="info-top">
                  <span class="data-info"><c:out value="${product.store.name}"/></span>
                  <h1 class="title-3"><c:out value="${product.name}"/></h1>
                </div>
                <div class="info-bot">
                  <div class="mini-data"><c:out value="${product.categoryThree.name}"/></div>
                  <div class="amount-price">
                    <h3 class="title-3 mini-data">
                      <form action="/shop/plus" method="post" class="form-sign form-add-newitem">
                        <fmt:formatNumber value="${product.price}" type="number" maxFractionDigits="2" /> COP
                        <input type="hidden" name="idProduct" value="${product.id}">
                        <button class="icon-sign-add-item"><i class='bx bxs-cart-add'></i></button>
                      </form>
                    </h3>
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>
        </c:if>
      </div>
    </div>
  </div>
</body>
  <script>
    // Get the number input element
    const numberInput = document.getElementById('stars');
  
    // Disable the spin box functionality
    numberInput.addEventListener('wheel', (event) => {
      event.preventDefault();
    });
  
    numberInput.addEventListener('keydown', (event) => {
       // Prevent the up and down arrow keys from changing the value
      if (event.key === 'ArrowUp' || event.key === 'ArrowDown') {
          event.preventDefault();
      }
    });
  </script>
</html>
