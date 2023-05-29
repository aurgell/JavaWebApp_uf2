<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<html>
    <head>
    </head>
    <body>
        <jsp:useBean id="friend" scope="request" class="model.Friend" />
        <jsp:useBean id="message" scope="request" class="java.lang.String" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% if(message == null){
            message = ":";
            }
        %>
        <% if(friend.getName() != null){%>
        <h1>El usuario <%= message %></h1><BR>
        Nombre: <jsp:getProperty name="friend" property="name" /><BR>
        Dirección: <jsp:getProperty name="friend" property="address" /><BR>
        Teléfono: <jsp:getProperty name="friend" property="phone" /><BR>
        Edad: <jsp:getProperty name="friend" property="age" /><BR>
        Nivel de amistad: <jsp:getProperty name="friend" property="friendshipLevel" /><BR>
        Comentario: <jsp:getProperty name="friend" property="comments" /><BR><BR>
       <%}
        else{ %>
        Operación realizada con éxito.
        <%} %>
        <a href="../view/main.jsp">Volver al menu principal</a>
    </body>
</html>