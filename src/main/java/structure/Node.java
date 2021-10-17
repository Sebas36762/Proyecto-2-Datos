package structure;

public class Node <T> {
    private T data;
    private Node<T> left, right;

    public Node (T data){this(data, null, null);}

    public Node(T data, Node<T> left, Node<T> right){

        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setData(T data){this.data = data;}
    public T getData(){return data;}


    public void setLeft (T data){this.left = new Node<T>(data);}
    public void setLeft(Node<T> node){this.left = node;}
    public Node getLeft(){return left;}


    public void setRight (T data){this.right = new Node<T>(data);}
    public void setRight(Node<T> node){this.right = node;}
    public Node getRight(){return right;}


}
