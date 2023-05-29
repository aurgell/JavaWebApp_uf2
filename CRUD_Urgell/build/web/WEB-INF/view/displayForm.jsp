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
        <h1>Datos del usuario: </h1>
        <%
            Person user = (Person)request.getAttribute("user");
        %>
        <br/>
        <div>Name:      <% out.println(user.getFirstName()); %> </div>
        <div>Last Name    <% out.println(user.getLastName()); %> </div>
        <div>
            <h3>Address:</h3> 
            <% out.println(user.getAddress().getStreet());%>
            <% out.println(user.getAddress().getNumber());%> 
            <% out.println(user.getAddress().getTown());%>
            <% out.println(user.getAddress().getProvince());%>
        </div>
        <br/>
        
        <a href="/view/main.jsp">Volver al menu principal</a>

    </body>
</html>
