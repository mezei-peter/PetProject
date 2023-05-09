package hu.mpb.backendpetproject.model.pettree;

import hu.mpb.backendpetproject.model.generic.Pair;

import java.util.UUID;

public class PetNode {
    private final UUID uuid = UUID.randomUUID();
    private final String name;
    private final int weight;
    private final PetSpecies species;
    private PetNode leftChild;
    private PetNode rightChild;

    public PetNode(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.leftChild = null;
        this.rightChild = null;
        this.species = determineSpecies(weight);
    }

    private PetSpecies determineSpecies(int weight) {
        for (PetSpecies species : PetSpecies.values()) {
            if (species.fallsInWeightBounds(weight)) {
                return species;
            }
        }
        return null;
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

    public boolean hasLeftChild(UUID uuid) {
        if (leftChild == null) {
            return false;
        }
        return leftChild.uuid == uuid;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public boolean hasRightChild(UUID uuid) {
        if (rightChild == null) {
            return false;
        }
        return rightChild.uuid == uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean hasUUID(UUID uuid) {
        return this.uuid.equals(uuid);
    }

    public boolean hasAnyChild() {
        return leftChild != null || rightChild != null;
    }

    public void removeChild(ChildDirection direction) {
        switch (direction) {
            case LEFT -> leftChild = null;
            case RIGHT -> rightChild = null;
        }
    }

    public Pair<PetNode, PetNode> getLeftAndRightChild() {
        return new Pair<>(leftChild, rightChild);
    }

    public void setLeftAndRightChild(PetNode left, PetNode right) {
        leftChild = left;
        rightChild = right;
    }

    public PetSpecies getSpecies() {
        return species;
    }
}
