package com.example.proyecto2datos.IIStructure;

import java.util.Stack;

public class ExpressionTree {
    boolean isOperator(char c) {
        /*
        Entrada Char
        Salida Boolean
        Este metodo indetifica si el char es un operador.
         */
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        }
        return isParent(c);
    }

    boolean isParent(char c) {
        /*
        Entrada Char
        Salida Boolean
        Este metodo indetifica si el char es un parentesis.
         */

        if (c == '(' || c == ')') {
            System.out.println("yes");
            return true;
        }
        System.out.println("no");
        return false;
    }


    Node constructTree(char postfix[]) {
        /*
        Entrada Char list
        Salida Node
        Este metodo crea el árbol binario con la Char list

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
        Entrada Node Tree
        Salida double
        Este metodo es una calculadora que retorna el resultado de la operación que
        contenga el árbol.
         */
        if (tree.left == null && tree.rigth == null) {

            return toDigit(tree.value);
        } else {
            double result = 0.0;

            double left = calculator(tree.left);
            double right = calculator(tree.rigth);
            String operator = tree.value;

            switch (operator) {
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
        Entrada String
        Salida int
        Este metodo convierte el digito a entero.
         */
        char i = e.charAt(0);
        return  i - '0';


    }

    public static double main (String ex){

        ExpressionTree et = new ExpressionTree();
        Postfix postfix = new Postfix();
        Node root = et.constructTree(postfix.convertToPostfix(ex).toCharArray());
        System.out.println( et.calculator(root));
        return et.calculator(root);

    }


}


