<%-- 
    Document   : index
    Created on : 25 may 2023, 18:00:55
    Author     : albert
--%>
<% 
    
    boolean auth = false;
    session.setAttribute("auth", auth);
    response.sendRedirect("view/main.jsp");
%>

<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->

