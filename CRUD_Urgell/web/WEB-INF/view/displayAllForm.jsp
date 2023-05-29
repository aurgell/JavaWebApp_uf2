<%@page import="java.util.ArrayList"%>
<%@page import="model.Person"%>
<%@page import="model.Address"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head>
    </head>
    <body>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <h1>Datos de los usuarios: </h1>

        <%
            ArrayList<Person> users = (ArrayList<Person>) request.getAttribute("users");
            for (Person f : users) {
        %>
        <br/>
        <div>Name:      <% out.println(f.getFirstName()); %> </div>
        <div>Last Name    <% out.println(f.getLastName()); %> </div>
        <div>
            <h3>Address:</h3> 
            <% out.println(f.getAddress().getStreet());%>
            <% out.println(f.getAddress().getNumber());%> 
            <% out.println(f.getAddress().getTown());%>
            <% out.println(f.getAddress().getProvince());%>
        </div>
        <br/>
        <%
            }
        %>
        <!--
        <--jsp:useBean id="friend" scope="request" class="model.Friend" />
        Nombre: <--jsp:getProperty name="friend" property="name" /><BR>
        Dirección: <--jsp:getProperty name="friend" property="address" /><BR>
        Teléfono: <--jsp:getProperty name="friend" property="phone" /><BR>
        Edad: <--jsp:getProperty name="friend" property="age" /><BR>
        Nivel de amistad: <--jsp:getProperty name="friend" property="friendshipLevel" /><BR>
        Comentario: <--jsp:getProperty name="friend" property="comments" /><BR>
        -->
        <a href="/view/main.jsp">Volver al menu principal</a>

    </body>
</html>
