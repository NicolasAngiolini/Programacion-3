package src.main.java.tp3;

import java.util.Collection;

public class Node {

    private int key;
    private Node left;
    private Node right;

    public Node(int key) {
        this.key = key;
    }

    public Node getRight() {
        return right;
    }

    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    public boolean isLeaf() {
        return this.getRight() == null && this.getLeft() == null;
    }

}
