package com.example.proyecto2datos.structure;

public class Utils {
    public Utils() {
    }

    public static void printTree(Node root) {
        printTree("", root, false);
    }

    private static void printTree(String prefix, Node node, boolean isleft) {
        if (node != null) {
            System.out.println(prefix + (isleft ? " ├── " : " └── ") + node.getData());
            printTree(prefix + (isleft ? " |  " : "   "), node.getLeft(), true);
            printTree(prefix + (isleft ? " |  " : "   "), node.getRight(), false);
        }

    }

    public static String reverse(String list){
        int i = 0;
        int l = list.length();
        char[] expression_work = list.toCharArray();
        String restructure = "";

        while (i<l){
            restructure= restructure + expression_work[l-1];
            l--;

        }
        return restructure;
    }

    public static String separate() {
        return separate();
    }

    public static String separate(String expression){

        //String expression_exit;
        String expression_operator = "";
        String expression_num = "";
        char[] expression_work = expression.toCharArray();
        int i = 0;

        while( i < expression_work.length) {
            if (expression_work[i] == '+' || expression_work[i] == '-'
                    || expression_work[i] == '*' || expression_work[i] == '/' || expression_work[i] == '^') {
                expression_operator = expression_operator + expression_work[i];
            } else if(expression_work[i] == '(' || expression_work[i] == ')'){
                expression_operator = expression_operator;
            } else{
                expression_num = expression_num + expression_work[i];
            }
            i++;
        }

        System.out.println(expression_num + expression_operator);
        return expression_num + reverse(expression_operator);
    }
}

