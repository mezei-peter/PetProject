package hu.mpb.backendpetproject.service.binarytree;

import hu.mpb.backendpetproject.model.PetBinaryTree;
import hu.mpb.backendpetproject.model.PetNode;

import java.util.Set;
import java.util.UUID;

public interface PetBinaryTreeService {
    void addNodeToRoot(PetNode root, int weight, String name);

    Set<PetNode> convertToSet(PetNode root);

    void deleteNode(PetNode petNode, PetBinaryTree tree);

    PetNode findNodeInSubTree(PetNode root, UUID uuid);
}
