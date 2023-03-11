package hu.mpb.backendpetproject.model;

import hu.mpb.backendpetproject.service.binarytree.BinaryTreeService;

public class BinaryTree {
    private Node root;
    private final BinaryTreeService binaryTreeService;

    public BinaryTree(BinaryTreeService binaryTreeService) {
        root = null;
        this.binaryTreeService = binaryTreeService;
    }

    public void addNode(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        binaryTreeService.addNodeToRoot(node, root);
    }
}
