<%-- 
    Document   : generacio
    Created on : 18/10/2021, 00:19:27
    Author     : evilmonkey19
--%>

<%@page import="entity.Incidencies"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generacio Ticket</title>
    </head>
    <body>
        <h1>Incidencia generada:</h1>
        <%Incidencies incidencia = (Incidencies) request.getAttribute("Incidencia");%>
        <h2>ID: <%=incidencia.toString()%> </h2>
        <h2>Centre: <%=incidencia.toString()%> </h2>
        <h2>Causa: <%=incidencia.toString()%> </h2>
        <h2>Relevancia: <%=incidencia.toString()%> </h2>
    </body>
</html>
