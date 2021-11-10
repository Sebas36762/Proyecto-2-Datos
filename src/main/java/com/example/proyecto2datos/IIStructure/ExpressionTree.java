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


    public Node constructTree(char postfix[]) {
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
    public static int precedence(char ch)
    {
        /*
        Entrada Char
        Salida Entero
        Este metodo indetifica si el char es un operador.
         */
        if(ch=='+' || ch=='-')
            return 1;

        else if(ch=='*' || ch=='/')
            return 2;

        return 0;
    }
    public static String convertToPostfix(String exp)
    { /*
         Entrada String, la expresión infija
         Salida String,  la expresión postfija
         Este metodo convierte el string (expresión) de fija a postfija.
              */

        Stack<Character> operators = new Stack<>();
        Stack<String> postFix = new Stack<>();

        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);         // current character.

            if(ch=='(')
                operators.push(ch);

            else if((ch>='0' && ch<='9') || (ch>='A' && ch<='Z'))
                postFix.push(ch+"");

            else if(ch==')')
            {
                while(operators.peek()!= '(')
                {
                    // STEP 5 of Algorithm.
                    char op = operators.pop();

                    String first = postFix.pop();          // get the two operands.
                    String second = postFix.pop();

                    String new_postFix = second+first+op;

                    postFix.push(new_postFix);
                }

                operators.pop();
            }


            else if(ch=='+' || ch=='-' || ch== '*' || ch== '/')
            {

                while(operators.size()>0 && operators.peek()!='(' && precedence(ch) <= precedence(operators.peek()))
                {
                    char op = operators.pop();

                    String first = postFix.pop();
                    String second = postFix.pop();

                    String new_postFix = second+first+op;

                    postFix.push(new_postFix);
                }

                operators.push(ch);
            }
        }


        while(operators.size()>0)
        {
            char op = operators.pop();

            String first = postFix.pop();
            String second = postFix.pop();

            String new_postFix = second+first+op;

            postFix.push(new_postFix);
        }

        return postFix.pop();
    }

}


