package com.example.proyecto2datos.IIStructure;
import java.util.Stack;
public class Node {
    /*
    Clase auxiliar para la creación del nodo,
    con capacidades de balancear entre izquierda y derecha.
    Valor Permitido tipo: String
     */
    String value;
    Node left, rigth;
    Node (String item){
        value = item;
        left = rigth = null;
    }

    }

