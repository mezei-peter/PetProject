package hu.mpb.backendpetproject.model;

import hu.mpb.backendpetproject.service.binarytree.PetBinaryTreeService;

import java.util.Set;

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

    public Set<PetNode> asSet() {
        if (root == null) {
            return null;
        }
        return petBinaryTreeService.convertToSet(root);
    }
}
