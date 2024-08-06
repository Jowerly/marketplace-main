<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="/styles/product.css">
  <link rel="stylesheet" href="/styles/menu.css">
  <title>Products</title>
</head>

<body class="bgshow">
  <nav class="menu">
    <section class="menu_container">
        <h1 class="menu_logo">Logo</h1>
        <ul class="menu_links">
            <li class="menu_item">
                <a href="#" class="menu_link">Home</a>
            </li>
            <li class="menu_item">
                <a href="/memberships" class="menu_link">Membresias</a>
            </li>
            <li class="menu_item menu_item--show">
                <a href="#" class="menu_link">Categorias <span class="icono1"><i class='bx bx-chevrons-right' id="menu_arrow" style='color: #FFf'></i></span></a>
                <ul class="menu_nesting">
                  <c:forEach items="${categoriesOne}" var="categoryOne">
                    <li class="menu_inside">
                        <a href="/category/1/${categoryOne.id}" class="menu_link--inside">
                            <c:out value="${categoryOne.name}" />
                        </a>
                    </li>
                </c:forEach>
                </ul>
            </li>
            <li class="menu_item">
                <span class="carrito-principal"><a href="/shop/cart/" class="menu_link"><i class='bx bxs-cart'></i></a></span>
            </li>
            <c:if test="${empty user}">
                <li class="menu_item">
                    <a href="/login" class="menu_link">Iniciar session</a>
                </li>
                <li class="menu_item">
                    <a href="/register" class="menu_link">Registrarse</a>
                </li>
            </c:if>
            <c:if test="${not empty user}">
                <li class="menu_item">
                    <a href="/logout" class="menu_link">Logout</a>
                </li>
            </c:if>
        </ul>
        <div class="menu_hamburguer">
            <i class='bx bx-align-justify' id="menu_img" style='color:#ffffff'></i>
        </div>
    </section>
</nav>
  <div class="container">
    <h2 class="title"> Tus Productos  </h2>
    <a href="/products/new" class="btn btn-dark "> Crea un nuevo Producto </a>
    <div class="row row-cols-1 justify-content-center">
      <c:forEach items="${productos}" var="product">
        <div class="col-3">
          <div class="card border-light prod">
            <c:if test="${empty product.linkImage}">
              <img src='https://img.freepik.com/free-vector/illustration-gallery-icon_53876-27002.jpg' class="card-img-top imagen-producto" alt="">
            </c:if>
            <c:if test="${not empty product.linkImage}">
              <img src="${product.linkImage}" class="card-img-top imagen-producto" alt="">
            </c:if>
            <div class="card-header cdstore"> <c:out value="${product.store.name}" />  </div>
            <div class="card-body">
              <h5 class="card-header"> <a href="/products/${product.id}/" style="text-decoration: none; color: var(--color15);"> <c:out value="${product.name}" /> </a> </h5>
              <p class="card-text"> <c:out value="${product.price}" />   </p>
              <p class="card-text"><a class="link-white" href="/category/3/${product.categoryThree.id}"><c:out value="${product.categoryThree.name}" /></a>  </p>
              <form id="addItem" action="/shop/add-item" method="POST">
                <input type="hidden" name="idProduct" value="${product.id}"/>
                <button class="container-icon-cart">
                  <span><i class='bx bxs-cart-add'></i></span>
                </button>
              </form>
            </div>
            <c:forEach items="${product.valorationProducts}" var="valoration"> 
              <p class="card-text btn btn-warning stars"><c:out value="${valoration.stars}" /> 4
                <span class="icon-cart"><i class='bx bx-star'></i></span>
              </p>
            </c:forEach>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>
