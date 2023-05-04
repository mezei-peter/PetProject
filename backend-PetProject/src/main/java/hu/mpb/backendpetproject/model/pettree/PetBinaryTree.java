package hu.mpb.backendpetproject.model.pettree;

import hu.mpb.backendpetproject.service.binarytree.PetBinaryTreeService;

import java.util.Set;
import java.util.UUID;

public class PetBinaryTree {
    private PetNode root;

    private final PetBinaryTreeService petBinaryTreeService;

    public PetBinaryTree(PetBinaryTreeService petBinaryTreeService) {
        root = null;
        this.petBinaryTreeService = petBinaryTreeService;
    }


    public void addValue(String name, int weight) {
        if (root == null) {
            root = new PetNode(name, weight);
            return;
        }
        petBinaryTreeService.addNodeToRoot(root, weight, name);
    }

    public PetNode getRoot() {
        return root;
    }

    public void setRoot(PetNode root) {
        this.root = root;
    }

    public Set<PetNode> asSet() {
        if (root == null) {
            return null;
        }
        return petBinaryTreeService.convertToSet(root);
    }

    public PetNode findNode(UUID uuid) {
        if (root == null) {
            return null;
        }
        return petBinaryTreeService.findNodeInSubTree(root, uuid);
    }

    public void deleteNode(PetNode petNode) {
        petBinaryTreeService.deleteNode(petNode, this);
    }

    public void emptyRoot() {
        root = null;
    }
}
