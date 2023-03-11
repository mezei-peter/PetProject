package hu.mpb.backendpetproject.service.binarytree;

import hu.mpb.backendpetproject.model.PetNode;

public interface PetBinaryTreeService {
    void addNodeToRoot(PetNode root, int weight, String name);
}
