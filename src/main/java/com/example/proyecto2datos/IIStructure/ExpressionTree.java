package com.example.proyecto2datos.IIStructure;

import com.example.proyecto2datos.structure.Utils;

import java.util.Stack;

public class ExpressionTree {

    boolean isOperator(char c){
        if(c=='+' || c == '-' || c == '*' || c == '/' || c == '^'){
            return true;
        }
        return isParent(c);
    }
    boolean isParent(char c){
        if(c=='('||c==')'){
            System.out.println("yes");
            return true;
        }
        System.out.println("no");
        return false;
    }

    void inorder(Node t){
        Node t3;
        if(t != null){
            inorder(t.left);

            System.out.println(t.value + "  ");
            inorder(t.rigth);

        }
    }

    Node constructTree(char postfix[]){
        Stack<Node> st = new Stack<Node>();
        Node t, t1, t2;

        for (int i =0; i < postfix.length; i++){

            if(!isOperator(postfix[i])){
                t = new Node(postfix[i]);
                st.push(t);
            }

            else{
                t = new Node(postfix[i]);

                t1= st.pop();
                t2 = st.pop();

                t.rigth = t1;
                t.left =t2;

                st.push(t);
            }
        }
        t = st.peek();
        st.pop();

        return t;
    }

    public static void main(String[] args) {
        Utils util = new Utils();

        ExpressionTree et = new ExpressionTree();
        String postfix = util.separate("(a*(c/a))-(h+n)");
        char[] charArray = postfix.toCharArray();
        Node root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);



    }

}
