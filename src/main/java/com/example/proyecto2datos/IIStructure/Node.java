package com.example.proyecto2datos.IIStructure;
import java.util.Stack;
public class Node {
    /**
     * Instituto Tecnológico de Costa Rica
     * Area de Ingeniería en Computadores
     *
     * Lenguaje: Java
     * Clase: Node
     * @version 1.0
     * @author Fabian Ceciliano y Sebastián Chaves
     *
     * Descripción:
     *     Creación del nodo para el funcionamiento del árbol,
     *     restricciones: Valores que no sea expresiones algebraicas, como letras o caracteres.
     *     Basado en GeeksforGeeks. (2021).
     *     GeeksforGeeks. (2021). Binary Tree Data Structure. https://www.geeksforgeeks.org/binary-tree-data-structure/
     */
    String value;
    Node left, rigth;
    Node (String item){
        value = item;
        left = rigth = null;
    }

    }

