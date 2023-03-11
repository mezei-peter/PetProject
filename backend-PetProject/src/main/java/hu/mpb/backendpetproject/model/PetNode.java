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
}
