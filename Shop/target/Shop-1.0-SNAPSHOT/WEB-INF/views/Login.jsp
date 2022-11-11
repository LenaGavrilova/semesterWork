<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/style/index.css" rel="stylesheet" type="text/css"/>
    <title>Login Form</title>
</head>
<body>

<div id="logForm">
    <form class="log" action="login" method="post">
        <h1> Sign in</h1>
        <p class="message">${mess}</p>
        <label class="loginInput">Login:
            <input name="login" type="text" class="logInput" placeholder="Login" required><br>
        </label>
        <label class="passwordInput">Password:
            <input name="password" type="password" class="logInput" placeholder="Password" required><br>
        </label>
        <div class="signIn">
            <button class="btn" type="submit">Sign in</button>
            <br>
        </div>
        <div class="newUser">
            <h3>If you do not have an account, create one. </h3>
            <a href="<c:url value="/register?login=${login}&password=${password}"/>"> Create new account</a><br>
        </div>
        <a href="home" class="back">Back</a><br>
    </form>

</div>

</body>
</html>