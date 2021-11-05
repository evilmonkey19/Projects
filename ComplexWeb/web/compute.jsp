<%-- 
    Document   : ComputeJSP
    Created on : 06/10/2021, 09:47:46
    Author     : evilmonkey19
--%>

<%@page import="entity.MyComplex"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP</title>
    </head>
    <body>
        <% MyComplex userComplex = (MyComplex) request.getAttribute("userComplex");%>
        <%--
        <% MyComplex refComplex = (MyComplex) getServletContext().getAttribute("refComplex");%>
        --%>
        <% MyComplex refComplex = (MyComplex) request.getSession().getAttribute("refComplex");%>
        <%! boolean bigger = false; %>
        <h1>User: <%=userComplex.toString()%> </h1>
        <h1>Ref: <%=refComplex.toString()%> </h1>
        <h1>Bigger? <%=userComplex.mod() > refComplex.mod()%> </h1>
        <h1> ID : <%=request.getSession(false).getId()%> </h1>
    </body>
</html>
