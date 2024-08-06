<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Show Store</title>
  <link rel="stylesheet" href="/styles/main.css">
  <link rel="stylesheet" href="/styles/show.css">
  <link rel="stylesheet" href="/styles/shop-cart.css">
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
  <div class="container-main">
    <div class="container-left">
      <div class="container-info subcontainer-2">
        <h1 class="title-1"><span class="icon"><i class='bx bxs-store-alt'></i> </span> <c:out value="${store.name}"/></h1>
        <span class="data">
          <span class="data-info">Empresa del rubro de <c:out value="${store.categoryOne.name}"/><br/></span>
          <span class="data-info">Teléfono: <c:out value="${store.telephoneNumber}"/><br/></span>
          <c:if test="${empty valorationsStore}">
            <span class="data-info">Cede: Virtual</span><br/>
          </c:if>
          <c:if test="${not empty valorationsStore}">
            <c:forEach items="${locales}" var="local">
              <!-- <span class="data-info"><c:out value="${local.openingHours}"/> Estrellas<br/></span>
              <span class="data-info"><c:out value="${local.closingHours}" /><br/></span> -->
              <span class="data-info">Cede:
                <c:out value="${local.districts.get(0).name}"/>,
              <c:out value="${local.districts.get(0).department.name}"/>-Colombia<br/></span>
            </c:forEach>
          </c:if>
          <span class="data-info">Email: <c:out value="${store.email}"/><br/></span>
          <span class="data-info">RUC: <c:out value="${store.ruc}"/></span>
        </span>
      </div>
      <div class="container-valoration subcontainer-2">
        <h1 class="title-2">Valoraciones</h1>
        <h1 class="title-3">Valoralo Aqui</h1>
        <form:form  action="/valoration-store/new" method="post" modelAttribute="valorationStore">
          <form:input path="store" type="hidden" value="${store.id}" id="store" class="form-pt"/>
          <div class="input-group-row">
            <div class="stars-box form-box">
              <form:label path="stars">Stars(0-5)</form:label>
              <form:input required="required" path="stars" type="number" id="stars" min="0" max="5" step="1" value="5" class="form-pt"/>
            </div>
            <div class="input-box form-box">
              <form:label path="review" class="label-animated">Review</form:label>
              <form:input path="review" type="text" id="review" class="form-pt"/>
            </div>
            <div class="btn-box form-box">
              <button class="btn form-pt">Calificar</button>
            </div>
          </div>
        </form:form>
        <c:if test="${empty valorationsStore}">
          <span class="data-info text-danger">Aún no hay valoraciones!</span><br/>
        </c:if>
        <c:if test="${not empty valorationsStore}">
          <c:forEach items="${valorationsStore}" var="valoration">
            <div class="content-valoration">
              <div class="item-info">
                <div class="info-top">
                  <span class="data-info"><c:out value="${valoration.stars}"/></span>
                  <c:forEach var = "i" begin = "1" end = "${valoration.stars}">
                    <i class='bx bxs-star'></i>
                  </c:forEach>
                  <span class="data-info"><c:out value="${valoration.createdAt}"/></span>
                </div>
                <div class="info-bot">
                  <div class="mini-data"><c:out value="${valoration.review}"/></div>
                </div>
              </div>
            </div>
          </c:forEach>
        </c:if>
      </div>
    </div>
    <div class="container-right">
      <div class="container-msc subcontainer-2">
        <h1 class="title-2">Miscelanea</h1>
      </div>
      <div class="container-items subcontainer-2">
        <h1 class="title-2">Productos de la Tienda</h1>
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
