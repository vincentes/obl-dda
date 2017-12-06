<%-- 
    Document   : home
    Created on : 14/11/2017, 08:27:40 PM
    Author     : alumnoFI
--%>

<%@page import="restaurante.dominio.Mesa"%>
<%@page import="restaurante.dominio.Mozo"%>
<%@page import="restaurante.dominio.Sistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Mozo mozo = (Mozo) request.getSession().getAttribute("mozo");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Bienvenido, <%= mozo.getUsuario()%>!!</title>
    </head>
    <body>
        <h1>Inicio</h1>
        <table border =1>
            <tr>
                <td>Mesa:</td>
                <td>Estado:</td>

            </tr>
            <% for (Mesa mesa : mozo.getMesas()) {%>
            <tr>      
                <td><%= mesa.getNumero()%></td>
                <td><%= mesa.getAbierta() ? "ABIERTA" : "CERRADA"%></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
