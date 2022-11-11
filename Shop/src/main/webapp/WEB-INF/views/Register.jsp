<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/style/index.css" rel="stylesheet" type="text/css"/>
    <title>Register form</title>
</head>
<body>

<div id="regForm">
    <form class="reg" action="${pageContext.request.contextPath}/register" method="post">
        <h1> Sign up</h1>
        <p class="message">${message}</p>
        <p class="message">${message2}</p>
        <p class="message">${message3}</p>
        <p class="message">${message4}</p>
        <label class="loginInput">Login:
            <input name="login" type="text" class="logInput" placeholder="Login" required><br>
        </label>
        <label class="emailInput">Email:
            <input name="email" type="email" class="logInput" placeholder="Email" required><br>
        </label>
        <label class="countryInput">Country:
            <input name="country" type="text" class="logInput" placeholder="Country" required><br>
        </label>
        <label class="passwordInput">Password:
            <input name="password" type="password" class="logInput" placeholder="Password" required><br>
        </label>
        <label class="repasswordInput">Repeat password:
            <input name="repassword" type="password" class="logInput" placeholder="Repeat password" required><br>
        </label>
        <div class="signUp">
            <button class="btn" type="submit">Sign up</button>
            <br>
        </div>
        <div class="oldUser">
            <h3>If you have an account, sign in. </h3>
            <a href="login"> Sign in</a><br>
        </div>
        <a href="home" class="back">Back</a><br>
    </form>

</div>
</body>
</html>
