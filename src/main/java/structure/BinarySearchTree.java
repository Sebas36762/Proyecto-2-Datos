package structure;

import structure.Node;

public class BinarySearchTree {
    private Node<Integer> root;

    private Node<Integer> insert(int data, Node<Integer> node) {
        if (node == null) {
            return new Node(data);
        } else {
            if (data < node.getData()) {
                node.setLeft(insert(data,node.getLeft()));

            } else if (data > node.getData()) {
                node.setRight(insert(data, node.getRight()));
            }
        }

        return node;
    }

    public boolean Search( int data) {return Search(data, this.root);}

    public boolean Search(int data, Node<Integer> node){

        if(node == null){
            return false;
        } else if(node.getData() > data){
            return Search(data, node.getRight());
        } else if( node.getData() < data){
            return Search(data, node.getLeft());
        } else{
            return true;
        }

    }
    public int getMin(){return getMin(this.root);}
    public int getMin(Node<Integer> node) {
        if (node.getLeft() == null) {
            return node.getData();
        } else {
            return getMin(node.getLeft());
        }
    }

     public int getMax(){return getMax(this.root);}

     public int getMax(Node<Integer> node){
            if (node.getRight()==null){
                return node.getData();
            } else{
                return getMax(node.getRight());
            }

    }

}
