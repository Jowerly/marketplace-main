<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Recibos</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="/styles/product.css">
</head>
<body>
  <div class="bgshow">
  <div class="container "> 
  <div id="printableArea">
  <h2> FACTURA </h2>
  
  <div>

  <p> Cliente: <c:out value="${order.client.firstName}" /> <c:out value="${order.client.lastName}" /> </p>  
  <p> Numero de Telefono: <c:out value="${order.client.telephoneNumber}" />  </p>  
  <p> Documento de Identidad: <c:out value="${order.client.numberDocumentIdentity}" />  </p>  
  <p> Email: <c:out value="${order.client.email}" /> </p>


  <p> Direccion: <c:out value="${direction.adress}" /> </p>
  <p> Fecha de Pedido: <c:out value="${order.createdAt}" /> </p>
  </div>

  <h3> Productos Solicitados </h3>

  <table class="table table-danger">
  <c:set var="sum" value="${0}" />
  <c:forEach var="product" items="${order.products}" >

    <tr>
    <th scope="col">   Cantidad: </th>
    <th scope="col">  Nombre del Producto: </th> 
    <th scope="col">  Precio Por Unidad: </th>
    </tr> 
      <tr>
        <td>
        <c:out value="${productservice.amount}"/> 
        </td>

        <td>
      <c:out value="${product.name}"/>
        </td>

        <td>
      <c:out value="${product.price}" /> 
        </td>
      </tr>

    <c:set var="sum" value="${sum + product.price}" />
  </c:forEach>
  </table>
  <h2> Total: <c:out value="${sum}" /></h2>
  </div>
  <input type="button" onclick="printDiv('printableArea')" value="Imprime tu Factura !" />
</div>
</div>
  
</body>
<script>
  function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    var originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;
  }
</script>
</html>
