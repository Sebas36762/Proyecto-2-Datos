        <%@ page import="com.example.proyecto2datos.IIStructure.ExpressionTree" %>
<%@ page import="com.example.proyecto2datos.IIStructure.Postfix" %>
<%@ page import="com.example.proyecto2datos.IIStructure.Node" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>BinaryTree</title>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <%
        String Value = "";
        String resultado;
        if (request.getParameter("BotonEnv") != null) {
            Value = request.getParameter("txtdatos");
            String ex = request.getParameter("txtdatos");
            System.out.println(ex);
            ExpressionTree et = new ExpressionTree();
            Postfix postfix = new Postfix();
            Node root = et.constructTree(postfix.convertToPostfix(ex).toCharArray());
            resultado = String.valueOf(et.calculator(root));
            System.out.println(resultado);
        } else
            return;


    %>




</head>

<body>
<div id="Cuadro">
    <h4>
            <%=Value%>
        <br></br>
        El resultado de la expresión ingresada es:

        <%=resultado%>


    </h4>





</div>


</body>
</html>