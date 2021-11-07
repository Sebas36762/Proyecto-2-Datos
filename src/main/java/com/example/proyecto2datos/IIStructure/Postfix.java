package com.example.proyecto2datos.IIStructure;

import java.util.Stack;

public class Postfix {


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



