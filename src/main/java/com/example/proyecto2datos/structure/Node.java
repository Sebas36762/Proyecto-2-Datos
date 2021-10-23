package com.example.proyecto2datos.structure;



public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        this(data, (Node)null, (Node)null);
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setLeft(T data) {
        this.left = new Node(data);
    }

    public void setLeft(Node<T> node) {
        this.left = node;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setRight(T data) {
        this.right = new Node(data);
    }

    public void setRight(Node<T> node) {
        this.right = node;
    }

    public Node getRight() {
        return this.right;
    }
}
