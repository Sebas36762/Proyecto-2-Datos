package com.example.proyecto2datos.IIStructure;
import java.util.Stack;
public class Node {
    char data;
    Node left, rigth;
    Node(char data){

        this.data = data;
        this.left = this.rigth = null;
    }
    Node(char data, Node left, Node rigth){
        this.data = data;
        this.left = left;
        this.rigth = rigth;


    }
}
