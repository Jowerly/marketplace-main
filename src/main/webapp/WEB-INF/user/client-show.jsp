<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Perfil del Cliente</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="/styles/client.css">
  <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
  <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
</head>
<body>
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
  <div class="row" style="width: 100%;">
    <div class="col-md-3">
      <ul class="list-group">
        <li class="list-group-item"><a href="#">Retirar</a></li>
        <li class="list-group-item"><a href="#">Historial de saldo</a></li>
        <li class="list-group-item"><a href="#">Mis notificaciones</a></li>
        <li class="list-group-item"><a href="/logout">Cerrar sesión</a></li>
      </ul>
    </div>
    <div class="col-md-9">
      <h2>Perfil del Cliente</h2>
      <div class="form-group">
        <span>Nombre</span>
        <span class="form-control" id="name" ><c:out value="${client.firstName}" /></span>
      </div>
      <div class="form-group">
        <span>Apellido</span>
        <span class="form-control" id="lastName"><c:out value="${client.lastName}" /></span>
      </div>
      <div class="form-group">
        <span>Email</span>
        <span class="form-control" id="lastName"><c:out value="${client.email}" /></span>
      </div>
      <div class="form-group">
        <span>Número Telefónico</span>
        <span class="form-control" id="lastName"><c:out value="${client.telephoneNumber}" /></span>
      </div>
      <div class="form-group">
        <span>Carné de Identidad</span>
        <span class="form-control" id="lastName"><c:out value="${client.numberDocumentIdentity}" /></span>
      </div>
      <div class="form-group">
        <span>Estado de la cuenta</span>
        <c:if test="${client.isEnable}">
          <span class="form-control" id="lastName">Activa</span>
        </c:if>
        <c:if test="${not client.isEnable}">
          <span class="form-control" id="lastName">Inactiva</span>
        </c:if>
      </div>
      <div class="mt-3">
        <a href="/perfil">Datos</a> | 
        <a href="/perfil/password-reset">Cambio de contraseña</a> | 
        <a href="#">Notificaciones</a>
      </div>
    </div>
  </div>
</div>
</body>
</html>
