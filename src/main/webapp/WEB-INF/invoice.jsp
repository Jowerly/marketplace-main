<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="/styles/product.css">
</head>
<body>
    <div class="bgshow">
    <div class="container "> 
    <div id="printableArea">
    <h2 style="color: var(--colorbg);"> FACTURA </h2>
    <div class="row container">

        <div class="col border-top my-2 pt-3 bg-danger-subtle">

        <p> Numero de Pedido: 
            <h3><c:out value="A-0${order.id}" />  </h3></p>
        <p> Fecha de Pedido: 
            <h3> <c:out  value="${date}" /> </h3></p>
        </div>

            <div class="col border-top my-2 pt-3 bg-danger-subtle">
            <p> Cliente: 
            <h5> <c:out value="${order.client.firstName}" /> <c:out value="${order.client.lastName}" /></h5> </p>  
            <p> Numero de Telefono: 
            <h5> <c:out value="${order.client.telephoneNumber}" />  </h5> </p>  
            <p> Documento de Identidad: 
            <h5> <c:out value="${order.client.numberDocumentIdentity}" /> </h5> </p>  
            </div>

                <div class="col border-top my-2 pt-3 bg-danger-subtle">
                <p> Email:
                    <h5> <c:out value="${order.client.email}" /> </h5> </p>
                <p> Direccion: 
                    <h5> <c:out value="${direction.adress}" /> </h5> </p>
                </div>
    
    </div>

    <h3> Productos Solicitados </h3>

    

    <table class="table table-danger text-xl-end">
    <c:set var="sum" value="${0}" />
    <c:set var="ivatotal" value="${0}" />

    <tr>
        <th scope="col">   Cantidad: </th>
        <th scope="col">    Nombre del Producto: </th> 
        <th scope="col">    Precio Por Unidad: </th>
    </tr> 
    <c:forEach var="product" items="${order.products}" >

    
            <tr>
                <td >
                    <c:forEach var="productservice" items="${productservice}" >
                    <p>  <c:out value="${productservice.amount}"/>   </p>
            
                    </c:forEach>
                </td>

                <td>
            <c:out value="${product.name}"/>
                </td>

                <td>
            <c:out value="${product.price}" /> 

            <c:set var="ivatotal" value="${ivatotal + (0.16 * product.price)}" />
                </td>
            </tr>

        <c:set var="sum" value="${sum + product.price}" />
    
    </c:forEach>
    </table>
    <div class="col border-top my-2 py-3 bg-danger-subtle text-end px-3">
    <h5> Subtotal: <fmt:formatNumber value="${sum}" type="number" maxFractionDigits="2"/></h5>
    <h5> IVA 16% : <fmt:formatNumber value="${ivatotal}" type="number" maxFractionDigits="2" /></h5>
    <h5> Total: <fmt:formatNumber value="${sum+ivatotal}" type="number" maxFractionDigits="2"/></h5>
    </div>


    
    </div>

    <input type="button" onclick="printDiv('printableArea')" value="Imprime tu Factura !" />
    
    <div class="text-end py-3"> 
    <a href="/orders" class="btn btn-dark">Back to Orders</a>
    </div>

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