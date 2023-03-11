package hu.mpb.backendpetproject.model;

public class Node {
    private final int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
