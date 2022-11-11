<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <title>Cart</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>

<body>
<jsp:include page="/WEB-INF/views/Menu.jsp"></jsp:include>
<div class="shopping-cart">
    <div class="px-4 px-lg-0">
        <div class="pb-5">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="p-2 px-3 text-uppercase">Product</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Price</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Amount</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Delete</div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listCP}" var="o">
                                    <tr>
                                        <th scope="row">
                                            <div class="p-2">
                                                <img src="${o.pimage}" alt="" width="70"
                                                     class="img-fluid rounded shadow-sm">
                                                <div class="ml-3 d-inline-block align-middle">
                                                    <h5 class="mb-0"><a href="detail?pid=${o.pid}"
                                                                        class="text-dark d-inline-block">${o.pname}</a>
                                                    </h5><span class="text-muted font-weight-normal font-italic"></span>
                                                </div>
                                            </div>
                                        </th>
                                        <td class="align-middle"><strong>${o.pprice}</strong></td>
                                        <td class="align-middle">
                                            <strong>${o.pamount}</strong>
                                        </td>
                                        <form action="deleteFromCart" method="post">
                                            <input hidden name="login" value="${sessionScope.acc.login}">
                                            <input hidden name="id" value="${o.pid}">
                                            <td class="align-middle"><a class="text-dark">
                                                <button type="submit" class="btn btn-danger">Delete</button>
                                            </a>
                                            </td>
                                        </form>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Cost</div>
                    <div class="p-4">
                        <ul class="list-unstyled mb-4">
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Products</strong><strong>${cost}
                                rub</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Ship</strong><strong>Free
                                ship</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Package</strong><strong>100
                                rub</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                <h5 class="font-weight-bold">${costAll} rub</h5>
                            </li>
                        </ul>
                        <a href=${pageContext.request.contextPath}/WEB-INF/views/Order.jsp class="btn btn-dark rounded-pill py-2 btn-block">Buy</a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>

</html>


