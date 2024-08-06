<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Orders</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    :root {
      --colorbg: #191724;
      --colorfg: #e0def4;
      --color1: #eb6f92;
      --color2: #9ccfd8;
      --color3: #f6c177;
      --colormain1: #ebbcba;
    }

    body {
      background-color: var(--colorbg);
      color: var(--colorfg);
    }

    .container {
      background-color: var(--colorbg);
      padding: 20px;
      border-radius: 8px;
    }

    h2 {
      color: var(--colormain1);
    }

    .table {
      background-color: var(--colorbg);
      color: var(--colorfg);
    }

    .table th, .table td {
      border-color: var(--colorfg);
    }

    .table-striped tbody tr:nth-of-type(odd) {
      background-color: var(--color1);
    }

    .table-striped tbody tr:nth-of-type(even) {
      background-color: var(--color2);
    }

    .btn-primary {
      background-color: var(--color3);
      border: none;
    }

    .btn-primary:hover {
      background-color: var(--color3);
      border: none;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Orders</h2>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>ID</th>
      <th>Date</th>
      <th>Status</th>
      <th>Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
      <tr>
        <td>${order.id}</td>
        <td>${order.createdAt}</td>
        <td>${order.deliveryStatus.name}</td>
        <td><a href="${pageContext.request.contextPath}/orders/${order.id}" class="btn btn-primary">View</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>