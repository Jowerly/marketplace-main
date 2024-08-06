<%@ page isErrorPage="true" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Crear Tienda</title>
  <link rel="stylesheet" href="/styles/main.css">
  <link rel="stylesheet" href="/styles/form.css">
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>

  <div class="background"></div>

  <div class="container">
    <div class="content">
      <h2 class="logo"><i class='logo-main-content'></i> Tienda X</h2>
      <div class="text-sci">
        <h2>Bienvenido<br><span> <c:out value="${seller.firstName} ${seller.lastName}"/></span></h2>
        <p>¡Hoy es un buen día para dar a conocer tu negocio!</p>
        <div class="social-icons">
          <a href="https://www.linkedin.com/"><i class='bx bxl-linkedin' ></i></a>
          <a href="https://www.facebook.com/"><i class='bx bxl-facebook' ></i></a>
          <a href="https://www.instagram.com/"><i class='bx bxl-instagram' ></i></a>
          <a href="https://github.com/m1gu3l-d3v/marketplace/"><i class='bx bxl-github'></i></a>
        </div>
      </div>
    </div>
    <div class="logreg-box">
      <div class="form-box register">
        <form:form action="/stores/new" method="post" modelAttribute="store" class="form">
          <div>
            <h2>Crear Tienda Virtual</h2>
          </div>
          <input type="hidden" name="idSeller" value="${seller.id}" id="sellerId" />

          <div class="input-group-row">
            <div class="input-box">
              <span class="icon"><i class='bx bxs-store-alt'></i></span>
              <form:input required="required" path="name" type="text" id="name" />
              <form:errors path="name" class="text-danger" />
              <form:label path="name">Nombre de la empresa</form:label>
            </div>

            <div class="select-box">
              <label for="categoryOne">Categoria:
                <select name="categoryOne" path="categoryOne" id="categoryOne" class="btn select">
                  <c:forEach items="${categoriesOnes}" var="categoryOne">
                    <option value="${categoryOne.id}">${categoryOne.name}</option>
                  </c:forEach>
                </select>
              </label>
            </div>
          </div>

          <div class="input-group-row">
            <div class="input-box">
              <span class="icon"><i class='bx bxs-envelope'></i></span>
              <form:input required="required" path="email" type="email" id="email" />
              <form:errors path="email" class="text-danger" />
              <form:label path="email">Email de la empresa</form:label>
            </div>

            <div class="input-box">
              <span class="icon"><i class='bx bxs-envelope'></i></span>
              <form:input required="required" path="ruc" type="text" id="ruc" />
              <form:errors path="ruc" class="text-danger" />
              <form:label path="ruc">Ruc</form:label>
            </div>
          </div>

          <div class="input-group-row">
            <div class="input-box">
              <span class="icon"><i class='bx bxs-phone'></i></i></span>
              <form:input required="required" path="telephoneNumber" type="tel" id="phone" />
              <form:errors path="telephoneNumber" class="text-danger" />
              <form:label path="telephoneNumber">Teléfono</form:label>
            </div>

            <div class="input-box">
              <span class="icon"><i class='bx bxs-id-card'></i></span>
              <form:input required="required" path="ruc" type="tel" id="ruc" />
              <form:errors path="ruc" class="text-danger" />
              <form:label path="ruc">Carné de identidad</form:label>
            </div>
          </div>

          <div class="input-group-row">
            <div class="select-box">
              <label for="department">Departamento:
                <select name="department" id="department" onchange="updateDistricts()" class="btn select">
                  <c:forEach items="${departments}" var="department">
                    <option value="${department.id}">${department.name}</option>
                  </c:forEach>
                </select>
              </label>
            </div>

            <div class="select-box">
              <label for="district">Distrito:
                <select name="idDistrict" id="district" class="btn select">
                  <c:forEach items="${districts}" var="district">
                    <option value="${district.id}" class="${district.department.id}">${district.name}</option>
                  </c:forEach>
                </select>
              </label>
            </div>
          </div>

          <div class="input-group-row">
            <div class="input-box">
                <span class="icon"><i class='bx bxs-map'></i></span>
                <input type="text" name="direction" id="direction" required>
                <label>Direction</label>
            </div>
            <div class="input-box">
              <span class="icon"><i class='bx bxs-lock'></i></span>
              <input required="required" name="password" type="password" id="password" />
              <label path="password">Contraseña</label>
            </div>
          </div>

          <div class="remember-forgot">
            <label class="checkbox-label"><input type="checkbox" required />Estoy de acuerdo con los <a href="#"> términos y condiciones</a></label>
          </div>

          <div class="error-box">
            <span class="text-danger"><c:out value="${userError}"/></span>
            <span class="text-danger"><c:out value="${roleError}"/></span>
            <span class="text-danger"><c:out value="${passwordError}"/></span>
          </div>

          <button type="submit" class="btn">Crear</button>

          <div class="login-register">
            <p>¿No estas logeado? <a href="/login" class=""> Iniciar Sesión</a></p>
            <p>¿No tienes una cuenta? <a href="/register" class=""> Crear Cuenta</a></p>
          </div>
        </form:form>
      </div>
    </div>
  </div>
</body>
<script>
  function updateDistricts() {
    // Obtén el departamento seleccionado
    let selectedDepartment = document.getElementById('department').value;

    // Obtén todos los distritos
    let districts = document.getElementById('district').options;

    // Muestra solo los distritos que pertenecen al departamento seleccionado
    let firstDistrict = null;
    for (let i = 0; i < districts.length; i++) {
      if (districts[i].className === selectedDepartment) {
        districts[i].style.display = 'block';
        if (!firstDistrict) {
          firstDistrict = districts[i].value;
        }
      } else {
        districts[i].style.display = 'none';
      }
    }

    // Cambia el valor del select de distritos al primer distrito del departamento seleccionado
    document.getElementById('district').value = firstDistrict;
  }

  // Actualiza los distritos cuando la página se carga por primera vez
  window.onload = function() {
    updateDistricts();
  }
</script>
<script src="/scripts/form/form.js"></script>
<script src="/scripts/form/register.js"></script>
</html>
