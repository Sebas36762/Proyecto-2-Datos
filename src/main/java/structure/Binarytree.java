package structure;
import  structure.Node;
public class Binarytree <T> {
    public Node<T> root;

    public Binarytree(T data){root = new Node<>(data);}

    public static void main(String[] args) {
        Binarytree<Integer> tree = new Binarytree<>(6);
        tree.root.setLeft(12);
        tree.root.setRight(3);
        tree.root.getLeft().setLeft(4);
        tree.root.getRight().setRight(2);
        tree.root.getRight().getRight().setRight(12);
        Utils.printTree(tree.root);
    }




}
