<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <title>Home</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="${pageContext.request.contextPath}/style/index.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/Menu.jsp"></jsp:include>
<section class="welcomeText">
    <div class="container">
        <h1 class="heading">Book store</h1>
        <p class="headingText">Welcome! If you want to take an order, please login first. Happy shopping!</p>
    </div>
</section>

<div class="container">
    <div class="row">
        <jsp:include page="/WEB-INF/views/Left.jsp"></jsp:include>
        <div class="col-sm-9">
            <div id="content" class="row">
                <c:forEach items="${listP}" var="o">
                        <div class="product col-12 col-md-6 col-lg-4">
                            <div class="card">
                                <img class="card-img-top" src="${o.image}">
                                <div class="card-body">
                                    <h4 class="card-title show_txt"><a href="detail?pid=${o.id}"
                                                                       title="View Product">${o.name}</a></h4>
                                    <p class="card-text show_txt">${o.title}</p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">${o.price} rub</p>
                                        </div>
                                        <div class="col">
                                            <form action="addToCart" method="post">
                                                <input hidden name="login" value="${sessionScope.acc.login}">
                                                <input hidden name="id" value="${o.id}">
                                                <input hidden name="amount" value="1">
                                            <button type="submit" class="btn btn-success btn-block">Add to cart</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </c:forEach>


            </div>
            <button onclick="loadMore()" class="btn">Load more</button>

        </div>

    </div>
</div>

<jsp:include page="/WEB-INF/views/Footer.jsp"></jsp:include>

</body>
</html>

