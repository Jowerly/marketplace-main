<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Crear Tienda</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="/styles/product.css">
</head>

<body class="bgshow">
  <div class="row"> 
    <div class="col-6"> 
      <img  src="${product.linkImage}" class="img-fluid rounded-start imgshow"  alt="">
    </div>
      <div class="col-6 "> 
        <a href="/products" class="btn btn-outline-dark my-3 ">   <span class="icon"><i class='bx bx-arrow-to-left'></i></span>  Todos los Productos </a>
        <h2 class=""> Producto Detalles </h2>

        <div class="container"> 
          <div class="card-body boxshowdeailts rounded-4">
              <div class="card-header text-body-tertiary"> <c:out value="${product.store.name}" /> <span class="icon"><i class='bx bxs-store-alt'></i></span> </div>
              <h5 class="card-header fw-bolder productnameshow border-bottom border-dark pb-2"> <c:out value="${product.name}" />  </h5>
              <p class="card-text col-12"><small class="text-body-secondary"><c:out value="${product.categoryThree.name}" /></small></p>
              <p class="card-text fs-2 fw-bold"> $ <c:out value="${product.price}" />   </p>
            <div class="row text-center"> 
              <p class="card-text col"><small class="text-body-secondary border border-dark p-2 border-opacity-10 rounded-pill"><c:out value="${product.categoryThree.categoryTwo.name}" /></small></p>
              <p class="card-text col"><small class="text-body-secondary border border-dark p-2 border-opacity-10 rounded-pill"><c:out value="${product.categoryThree.categoryTwo.categoryOne.name}" /></small></p>
            </div>
          </div>
        </div>

      <!----------------           VALORATIONS- PRODUCTS ------------------->
      
      <div class="container mb-4">
        <div class=" card text-center card-review mt-2 ">
                    <div class="card-header">
                          <ul class="nav nav-tabs card-header-tabs ">
                            <li class="nav-item ">
                              <a class="nav-link califica" aria-current="true" href="/products/${product.id}"> Calificar </a>
                          </li>
                          <li class="nav-item ">
                              <a class="nav-link califica" href="/products/${product.id}/coments"> Comentarios </a>
                          </li>
                          
                          </ul>
                    </div>
        
              <div class="card-body ">
                  
                <h5 class="card-title">Califica este Producto</h5>

        

                    <form:form  action="/valorationproduct/new" method="post" modelAttribute="ValorationProduct">
                    <form:input path="product" type="hidden" value="${product.id}" id="product" />           
              
                      <div class="form-floating my-2">
                        <form:input path="review" type="textarea" id="review" class="form-control" placeholder=" Comentario" />
                        <form:label path="review" class="label-animated">Deja tu Comentario</form:label>
                        <form:errors class="text-danger" path="review"/>

                      </div>


                  
                      <div class="btn-group"  role="group" aria-label="Basic radio toggle button group">
                              <form:form id="formularioRadio()"  path="stars">
                                      <form:errors class="text-danger" path="stars"/>

                                      <input  type="radio" class="btn-check " name="stars" id="1" autocomplete="off" value="1" />
                                      <label path="stars" class="btn btn-outline-warning text-black " for="1"> 
                                        1  <span class="icon"><i class='bx bx-star'></i></span>           
                                      </label>
                                      
                                      <input  type="radio" class="btn-check" name="stars" id="2" autocomplete="off" value="2" />
                                      <label path="stars" class="btn btn-outline-warning text-black" for="2"> 
                                        2 <span class="icon"><i class='bx bx-star'></i></span>           
                                      </label>
                                  
                                      <input  type="radio" class="btn-check" name="stars" id="3" autocomplete="off" value="3" />
                                      <label path="stars" class="btn btn-outline-warning text-black" for="3"> 
                                        3 <span class="icon"><i class='bx bx-star'></i></span>           
                                      </label>

                                      <input  type="radio" class="btn-check" name="stars" id="4" autocomplete="off" value="4" />
                                      <label path="stars" class="btn btn-outline-warning text-black" for="4"> 
                                        4 <span class="icon"><i class='bx bx-star'></i></span>           
                                      </label>

                                      <input  type="radio" class="btn-check" name="stars" id="5" autocomplete="off" value="5" />
                                      <label path="stars" class="btn btn-outline-warning text-black" for="5"> 
                                        5 <span class="icon"><i class='bx bx-star'></i></span>           
                                      </label>
            
                                    
                              </div>

                              
                                <div class="btn-box form-box my-2">
                                  <button class="btn btn-outline-dark" type="submit">Calificar</button>
                                </div>                    
                              </form:form>
                  </form:form>
            
                  
                </div>


              

          </div>
    </div>








    </div>
  </div>
</body>

<script>

formularioRadio.addEventListener("submit", (e) => {
  e.preventDefault()
  seleccionado = document.querySelector('input[name="stars"]:checked').value;
  switch(seleccionado) {
    case '1':
        console.log("1")
      break;
    case '2':
        console.log("2")
      break;
    case '3':
        console.log("3")
      break;
    case '4':
        console.log("4")
      break;
    case '5':
        console.log("5")
      break;

    default:
        break;
  }
})

</script>



</html>