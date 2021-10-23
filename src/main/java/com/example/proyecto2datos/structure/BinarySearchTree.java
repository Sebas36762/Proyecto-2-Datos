package com.example.proyecto2datos.structure;

public class BinarySearchTree {
    private Node<Integer> root;

    public BinarySearchTree() {
    }

    private Node<Integer> insert(int data, Node<Integer> node) {
        if (node == null) {
            return new Node(data);
        } else {
            if (data < (Integer)node.getData()) {
                node.setLeft(this.insert(data, node.getLeft()));
            } else if (data > (Integer)node.getData()) {
                node.setRight(this.insert(data, node.getRight()));
            }

            return node;
        }
    }

    public boolean Search(int data) {
        return this.Search(data, this.root);
    }

    public boolean Search(int data, Node<Integer> node) {
        if (node == null) {
            return false;
        } else if ((Integer)node.getData() > data) {
            return this.Search(data, node.getRight());
        } else {
            return (Integer)node.getData() < data ? this.Search(data, node.getLeft()) : true;
        }
    }

    public int getMin() {
        return this.getMin(this.root);
    }

    public int getMin(Node<Integer> node) {
        return node.getLeft() == null ? (Integer)node.getData() : this.getMin(node.getLeft());
    }

    public int getMax() {
        return this.getMax(this.root);
    }

    public int getMax(Node<Integer> node) {
        return node.getRight() == null ? (Integer)node.getData() : this.getMax(node.getRight());
    }
}
