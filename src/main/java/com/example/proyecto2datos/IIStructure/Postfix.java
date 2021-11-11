package com.example.proyecto2datos.IIStructure;

import java.util.Stack;

public class Postfix {

     /*
    Instituto tecnológico de Costa Rica
    Ingeniería en computadores
    Estudiantes: Angelo Fabian Ceciliano Ortega, Sebastian Chaves Ruiz.

    Clase:Conversión de expresiones infijas a postfijas con metodos
    como el convertor y demás para apoyo.

    Restricciones: Char, Enteros, lista...
    Basado en la implementación de  Jain, S. (2020, 14 junio)
    Jain, S. (2020, 14 junio). Convert Infix to Postfix Expression - Java Code | TutorialHorizon. Algorithms.
        https://algorithms.tutorialhorizon.com/convert-infix-to-postfix-expression/
     */


    public static int precedence(char ch)
    {
         /*
        Instituto tecnológico de Costa Rica
        Ingeniería en computadores
        Estudiantes Angelo Fabian Ceciliano Ortega, Sebastian Chaves Ruiz.

        Función: Indentificar que tipo de operador es.
        entrada: Operador en char
        salida: Entero.
        Restricciones: Enteros, Strings, listas...
         */
        if(ch=='+' || ch=='-')
            return 1;

        else if(ch=='*' || ch=='/' || ch == '%')
            return 2;

        return 0;
    }
    public static String convertToPostfix(String exp)
    {   /*
        Instituto tecnológico de Costa Rica
        Ingeniería en computadores
        Estudiantes Angelo Fabian Ceciliano Ortega, Sebastian Chaves Ruiz.

        Función: Convertir la expresión de infija a postfija.
        entrada: Expresión en String.
        salida: El resultado de la conversión de la expresión en String.
        Restricciones: Enteros, Char, listas...
         */
        Stack<Character> operators = new Stack<>();
        Stack<String> postFix = new Stack<>();

        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);

            if(ch=='(')
                operators.push(ch);

            else if((ch>='0' && ch<='9') || (ch>='A' && ch<='Z')) //Se identifica el valor
                postFix.push(ch+"");

            else if(ch==')')
            {
                while(operators.peek()!= '(') //Se observa apartir de los parentesis
                {
                    // STEP 5 of Algorithm.
                    char op = operators.pop();

                    String first = postFix.pop();          // Obtención de dos operandos.
                    String second = postFix.pop();

                    String new_postFix = second+first+op;

                    postFix.push(new_postFix);
                }

                operators.pop();
            }


            else if(ch=='+' || ch=='-' || ch== '*' || ch== '/' || ch == '%')
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
