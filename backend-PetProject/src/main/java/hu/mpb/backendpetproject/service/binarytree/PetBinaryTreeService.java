package hu.mpb.backendpetproject.service.binarytree;

import hu.mpb.backendpetproject.model.PetNode;

import java.util.Set;

public interface PetBinaryTreeService {
    void addNodeToRoot(PetNode root, int weight, String name);

    Set<PetNode> convertToSet(PetNode root);

    void deleteNode(PetNode petNode);
}
