<%@ page isErrorPage="true" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
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
        <h2>Bienvenido...<br><span>Q tal tu dia?<span></h2>
        <p>Hoy es un buen dia para comprar un poco ;)</p>
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
        <form:form action="/register" method="post" modelAttribute="user" class="form">
          <div>
            <h2>Crear Cuenta</h2>
          </div>

          <div class="input-group-row">
            <div class="input-box">
              <span class="icon"><i class='bx bxs-user'></i></span>
              <form:input required="required" path="firstName" type="text" id="first-name" />
              <form:errors path="firstName" class="text-danger" />
              <form:label path="firstName">Nombres</form:label>
            </div>
            
            <div class="input-box">
              <span class="icon"><i class='bx bxs-user'></i></span>
              <form:input required="required" path="lastName" type="text" id="last-name" />
              <form:errors path="lastName" class="text-danger" />
              <form:label path="lastName">Apellidos</form:label>
            </div>
          </div>

          <div class="input-group-row">
            <div class="input-box">
            <span class="icon"><i class='bx bxs-envelope'></i></span>
            <form:input required="required" path="email" type="email" id="email" />
            <form:errors path="email" class="text-danger" />
            <form:label path="email">Correo</form:label>
            </div>

            <div class="option-box">
            <label>Rol</label>

            <div class="radio-container">
                <div class="radio-wrapper">
                <label class="radio-button">
                    <input name="radio-group" type="radio" value="client" >
                    <span class="radio-checkmark"></span>
                    <span class="radio-label">Cliente</span>
                </label>
                </div>

                <div class="radio-wrapper">
                <label class="radio-button">
                    <input name="radio-group" type="radio" value="seller">
                    <span class="radio-checkmark"></span>
                    <span class="radio-label">Vendedor</span>
                </label>
                </div>
                <!-- <span class="icon"><i class='bx bxs-id-card'></i></span> -->
            </div>
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
              <form:input required="required" path="numberDocumentIdentity" type="tel" id="numberDocumentIdentity" />
              <form:errors path="numberDocumentIdentity" class="text-danger" />
              <form:label path="numberDocumentIdentity">DNI</form:label>
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
            </div>

          <div class="input-group-row">
            <div class="input-box">
              <span class="icon"><i class='bx bxs-lock'></i></span>
              <form:input required="required" path="password" type="password" id="password" />
              <form:errors path="password" class="text-danger" />
              <form:label path="password">Contraseña</form:label>
            </div>

            <div class="input-box">
              <span class="icon"><i class='bx bxs-lock'></i></span>
              <form:input required="required" path="confirmPassword" type="password" id="confirmPassword" />
              <form:errors path="confirmPassword" class="text-danger" />
              <form:label path="confirmPassword">Confirmar Contraseña</form:label>
            </div>
          </div>

          <div class="remember-forgot">
            <label class="checkbox-label"><input type="checkbox" required />Estoy de acuerdo con los términos y condiciones</label>
          </div>

          <button type="submit" class="btn">Registrate</button>

          <div class="login-register">
            <p>¿Ya tienes una cuenta? <a href="#" class="login-link">Iniciar Sesión</a></p>
          </div>
        </form:form>
      </div>

      <div class="form-box login">
        <form action="/login" method="post">
          <h2>Iniciar Sesión</h2>
          <div class="input-box">
              <span class="icon"><i class='bx bxs-envelope'></i></span>
              <input type="email" name="email" id="email" required>
              <label>Correo</label>
          </div>

          <div class="input-box">
              <span class="icon"><i class='bx bxs-lock-alt'></i></span>
              <input type="password" name="password" id="password" required>
              <label>Contraseña</label>
          </div>

          <div class="remember-forgot">
            <label><input type="checkbox">Recordar contraseña</label>
            <a href="#">¿Olvidaste tu contraseña?</a>
          </div>

          <button type="submit" class="btn select">Entrar</button>

          <div class="login-register">
            <p>¿No tienes una cuenta? <a href="#" class="register-link">Crear cuenta nueva</a></p>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>


<script src="/scripts/form/form.js"></script>
<script src="/scripts/form/register.js"></script>
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
</html>