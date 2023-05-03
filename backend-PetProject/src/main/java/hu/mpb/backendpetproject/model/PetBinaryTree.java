package hu.mpb.backendpetproject.model;

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
        return findNodeInSubTree(root, uuid);
    }

    private PetNode findNodeInSubTree(PetNode subTreeRoot, UUID uuid) {
        if (subTreeRoot.hasUUID(uuid)) {
            return subTreeRoot;
        }
        if (subTreeRoot.hasLeftChild()) {
            PetNode leftResult = findNodeInSubTree(subTreeRoot.getLeftChild(), uuid);
            if (leftResult != null) {
                return leftResult;
            }
        }
        if (subTreeRoot.hasRightChild()) {
            PetNode rightResult = findNodeInSubTree(subTreeRoot.getRightChild(), uuid);
            if (rightResult != null) {
                return rightResult;
            }
        }
        return null;
    }

    public void deleteNode(PetNode petNode) {
        petBinaryTreeService.deleteNode(petNode);
    }
}
