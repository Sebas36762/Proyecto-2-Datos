
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%
        /** Instituto Tecnológico de Costa Rica
         * Area de Ingeniería en Computadores
         *
         * Lenguaje: Java
         * Clase: index.jsp
         * @version 1.0
         * @author Fabian Ceciliano y Sebastián Chaves
         * Descripcion:
         * Crecion de interfaz grafica del programa
         */
    %>
    <title>BinaryTree</title>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>

</head>
<body>
    <div id="Cuadro">
        <form name="Expresion" action="procesar.jsp" method="post">
            <p id="Titulo">Por favor ingrese la expresión a realizar:</p>
            <br/><br/>
            <input name="txtdatos" id="txtdatos" type="text" class="Entrada" required=""  />
            <br/><br/>
            <input type="submit"value="Enviar" id="BotonEnv" name="BotonEnv">
            <i class="fas fa-file-excel"></i> 
            <br/><br/>
        </form>


    </div>


</body>
</html>