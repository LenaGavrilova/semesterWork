<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <title>Header</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/index.css">
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
</head>

<body>
<nav class="navigation">
    <div class="container">
        <a class="brand" href="home">OurBooks</a>
        <div class="menu">
            <ul class="navbar">
                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="manager">Admin account</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="home">Hello ${sessionScope.acc.login}</a>
                    </li>
                    <li class="nav-item2">
                        <a class="nav-link2" href="logout">Logout</a>
                    </li>
                    <li class="nav-item3">
                        <a class="nav-link3" href="cart">Cart</a>
                    </li>

                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="login?login=1&password=1">Login</a>
                    </li>
                </c:if>
            </ul>

            <form action="search" method="post" class="search">
                <div class="inputSearch">
                    <input value="${txtS}" name="txt" type="text" class="formSearch" placeholder="Search item...">
                    <div class="menuButton">
                        <button onclick="searchByName(this)" type="submit" class="btn">Search
                            <i class="doSearch"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</nav>
</body>
</html>

