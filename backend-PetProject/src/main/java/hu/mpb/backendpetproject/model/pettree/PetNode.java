package hu.mpb.backendpetproject.model.pettree;

import java.util.UUID;

public class PetNode {
    private final UUID uuid = UUID.randomUUID();
    private String name;
    private int weight;
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

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean hasUUID(UUID uuid) {
        return this.uuid.equals(uuid);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
