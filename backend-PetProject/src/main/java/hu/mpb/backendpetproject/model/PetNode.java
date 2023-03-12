package hu.mpb.backendpetproject.model;

public class PetNode {
    private final String name;
    private final int weight;
    private PetNode left;
    private PetNode right;

    public PetNode(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.left = null;
        this.right = null;
    }

    public void setLeft(PetNode left) {
        this.left = left;
    }

    public void setRight(PetNode right) {
        this.right = right;
    }

    public PetNode getLeft() {
        return left;
    }

    public PetNode getRight() {
        return right;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
