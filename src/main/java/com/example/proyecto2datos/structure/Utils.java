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
}

