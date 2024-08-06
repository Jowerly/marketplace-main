<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Membresías</title>
  <link rel="stylesheet" href="/styles/membership.css">
</head>
<body>
  <div class="container-main">
    <h1 class="title">Membresías</h1>
    <div class="container-memership">

      <c:forEach items="${memberships}" var="membership">
        <c:set var="monthlyPrice" value="${membership.price / membership.months}" />
        <div id="membership-one" class="membership">
          <h1><c:out value="${membership.name}"/></h1>
          <p class="text-primary"><c:out value="${membership.price}"/> COP</p>
          <p class="text-secondary">*Cada mes pagas <c:out value="${monthlyPrice}" /> COP</p>
          <div class="form">
            <a href="/memberships/${membership.id}"><button class="btn">Comprar</button></a>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>