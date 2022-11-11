<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <title>About product</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="${pageContext.request.contextPath}/style/index.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/Menu.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <jsp:include page="/WEB-INF/views/Left.jsp"></jsp:include>
        <div class="col-sm-9">
            <div class="container">
                <form action="addToCart" method="post">
                    <input hidden name="login" value="${sessionScope.acc.login}">
                    <input hidden name="id" value="${detail.id}">
                    <input hidden name="amount" value="1">
                    <div class="card">
                        <div class="row">
                            <aside class="col-sm-5 border-right">
                                <article class="gallery-wrap">
                                    <div class="img-big-wrap">
                                        <div><a href="#"><img src="${detail.image}"></a></div>
                                    </div>
                                    <div class="img-small-wrap">
                                    </div>
                                </article>
                            </aside>
                            <aside class="col-sm-7">
                                <article class="card-body p-5">
                                    <h3 class="title mb-3">${detail.name}</h3>
                                    <p class="price-detail-wrap">
                                            <span class="price h3 text-warning">
                                                <span class="currency"></span><span
                                                    class="num">${detail.price} rub</span>
                                            </span>
                                    </p>
                                    <dl class="item-property">
                                        <dt>Description</dt>
                                        <dd><p>
                                            ${detail.description}
                                        </p></dd>
                                    </dl>
                                    <hr>
                                    <button type="submit" class="btn btn-lg btn-outline-primary text-uppercase"><i
                                            class="fas fa-shopping-cart"></i> Add to cart
                                    </button>
                                </article>
                            </aside>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/Footer.jsp"></jsp:include>
</body>
</html>

