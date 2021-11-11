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
        /** Instituto Tecnológico de Costa Rica
        * Area de Ingeniería en Computadores
        *
        * Lenguaje: Java
        * Clase: procesar.jsp
        * @version 1.0
        * @author Fabian Ceciliano y Sebastián Chaves
        * Descripcion:
        * Se toma la variable ingresada en el cuadro de texto en la clase "index.jsp" para su uso
        */
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
    <script src="https://unpkg.com/xlsx@0.16.9/dist/xlsx.full.min.js"></script>
    <script src="https://unpkg.com/file-saverjs@latest/FileSaver.min.js"></script>
    <script src="https://unpkg.com/tableexport@latest/dist/js/tableexport.min.js"></script>



</head>

<body>
<script>
    const $btnExportar = document.querySelector("#BotonEnv"),
        $tabla = document.querySelector("#Cuadro");

    $btnExportar.addEventListener("click", function() {
        let tableExport = new TableExport($tabla, {
            exportButtons: false, // No queremos botones
            filename: "Reporte de prueba", //Nombre del archivo de Excel
            sheetname: "Reporte de prueba", //Título de la hoja
        });
        let datos = tableExport.getExportData();
        let preferenciasDocumento = datos.tabla.xlsx;
        tableExport.export2file(preferenciasDocumento.data, preferenciasDocumento.mimeType, preferenciasDocumento.filename, preferenciasDocumento.fileExtension, preferenciasDocumento.merges, preferenciasDocumento.RTL, preferenciasDocumento.sheetname);
    });
</script>
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