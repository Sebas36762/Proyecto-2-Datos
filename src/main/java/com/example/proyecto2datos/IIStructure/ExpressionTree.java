package com.example.proyecto2datos.IIStructure;

import java.util.Stack;

public class ExpressionTree {
    /*
    Instituto tecnológico de Costa Rica
    Ingeniería en computadores
    Estudiantes: Angelo Fabian Ceciliano Ortega, Sebastian Chaves Ruiz.

    Clase: Creación de del árbol binario, calculador y funciones de apoyo
    restricciones: Valores que no sea expresiones algebraicas, como letras o caracteres.
    Basado en GeeksforGeeks. (2021).
    GeeksforGeeks. (2021). Binary Tree Data Structure. https://www.geeksforgeeks.org/binary-tree-data-structure/
     */
    boolean isOperator(char c) {
        /*
        Instituto tecnológico de Costa Rica
        Ingeniería en computadores
        Estudiantes Angelo Fabian Ceciliano Ortega, Sebastian Chaves Ruiz.

        Función: Identificar si el indice del char el operador.
        entrada: Operadores de tipo char.
        salida: Confirmación en manera de Booleanos.
        Restricciones: Enteros, Strings..
         */
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        }
        return isParent(c);
    }

    boolean isParent(char c) {
        /*
        Instituto tecnológico de Costa Rica
        Ingeniería en computadores
        Estudiantes Angelo Fabian Ceciliano Ortega, Sebastian Chaves Ruiz.

        Función: Identificar si el indice del char es un parentesis.
        entrada: Operadores de tipo char.
        salida: Confirmación en manera de Booleanos.
        Restricciones: Enteros, Strings..
         */

        if (c == '(' || c == ')') {
            System.out.println("yes");
            return true;
        }
        System.out.println("no");
        return false;
    }


    public Node constructTree(char postfix[]) {
         /*
        Instituto tecnológico de Costa Rica
        Ingeniería en computadores
        Estudiantes Angelo Fabian Ceciliano Ortega, Sebastian Chaves Ruiz.

        Función: Creación del árbol.
        entrada: Lista char con la expresión.
        salida: Node árbol.
        Restricciones: Enteros, Strings, lista String..
         */
        Stack<Node> st = new Stack<Node>();
        Node t, t1, t2;

        for (int i = 0; i < postfix.length; i++) {

            if (!isOperator(postfix[i])) {
                t = new Node(Character.toString(postfix[i]));
                st.push(t);
            } else {
                t = new Node(Character.toString(postfix[i]));

                t1 = st.pop();
                t2 = st.pop();

                t.rigth = t1;
                t.left = t2;

                st.push(t);
            }
        }
        t = st.peek();
        st.pop();

        return t;
    }

    public double calculator(Node tree) {

       /*
        Instituto tecnológico de Costa Rica
        Ingeniería en computadores
        Estudiantes Angelo Fabian Ceciliano Ortega, Sebastian Chaves Ruiz.

        Función: Calcular lo expresión que contiene el árbol.
        entrada: Node árbol.
        salida: El resultado de la expresión en Double.
        Restricciones: Enteros, Strings, listas...
         */
        if (tree.left == null && tree.rigth == null) {

            return toDigit(tree.value);
        } else {
            double result = 0.0;

            double left = calculator(tree.left);
            double right = calculator(tree.rigth);
            String operator = tree.value;

            switch (operator) { //Se hace el calculo dependiendo del operador
                case "+":
                    result = left + right;
                    break;
                case "-":
                    result = left - right;
                    break;
                case "*":
                    result = left * right;
                    break;
                case "/":
                    result = left / right;
                    break;
                case "%":
                    result = left % right;
                    break;
                default:
                    result = left + right;
                    break;
            }
            return result;
        }

    }
    public static int toDigit(String e) {
        /*
        Instituto tecnológico de Costa Rica
        Ingeniería en computadores
        Estudiantes Angelo Fabian Ceciliano Ortega, Sebastian Chaves Ruiz.

        Función: Convertir el indice en digito.
        entrada: Indice en string
        salida: Entero
        Restricciones: Enteros, Char, listas...
         */
        char i = e.charAt(0);
        return  i;


    }

   public static double main (String ex){

       ExpressionTree et = new ExpressionTree();
       Postfix postfix = new Postfix();
       Node root = et.constructTree(postfix.convertToPostfix(ex).toCharArray());
       System.out.println( et.calculator(root));
       return et.calculator(root);

    }


}


