package hu.mpb.backendpetproject.model;

public class PetNode {
    private final String name;
    private final int weight;
    private PetNode leftChild;
    private PetNode rightChild;

    public PetNode(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setLeftChild(PetNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(PetNode rightChild) {
        this.rightChild = rightChild;
    }

    public PetNode getLeftChild() {
        return leftChild;
    }

    public PetNode getRightChild() {
        return rightChild;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
