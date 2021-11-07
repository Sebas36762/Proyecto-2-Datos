<%@ page import="com.example.proyecto2datos.IIStructure.ExpressionTree" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>BinaryTree</title>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <%
        String Value ="";
        if(request.getParameter("BotonEnv")!=null){
            Value = request.getParameter("txtdatos");
        }else
            return;

    %>


</head>

<body>
<div id="Cuadro">
    <h4>
            <%=Value%>

    </h4>

    <%= ExpressionTree.main("")%>



</div>


</body>
</html>