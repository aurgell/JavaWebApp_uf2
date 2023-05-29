<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
</head>
<body>
    <%
        if ((Boolean)session.getAttribute("auth")) {
    %>
           <h1>Menú principal</h1>

        <h3><a href="readForm.html">Consultar los datos de una persona</a></h3>
        <h3><a href="updateForm.html">Cambiar una persona</a></h3>
        <h3><a href="deleteForm.html">Borrar</a></h3>
        <h3><a href="/FrontController?form=listServlet" >Listar todas las personas</a></h3>
        <h3><a href="/FrontController?form=logout"">Salir</a></h3>
    <%
        } else {
    %>
        <h3><a href="loginForm.html">Login</a></h3>
        <h3><a href="signupForm.html" >Sign Up</a></h3>
    <%
        }
    %>
</body>
</html>
