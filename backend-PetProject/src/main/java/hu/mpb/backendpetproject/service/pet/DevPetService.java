package hu.mpb.backendpetproject.service.pet;

import hu.mpb.backendpetproject.model.PetBinaryTree;
import hu.mpb.backendpetproject.model.PetNode;
import hu.mpb.backendpetproject.service.binarytree.SimplePetBinaryTreeService;

import java.util.UUID;

public class DevPetService implements PetService {
    private final PetBinaryTree petBinaryTree = new PetBinaryTree(new SimplePetBinaryTreeService());

    @Override
    public PetNode getPetNode() {
        if (petBinaryTree.getRoot() == null) {
            return null;
        }
        return petBinaryTree.getRoot();
    }

    @Override
    public PetNode insertPet(UUID randomUUID, String petName, int petWeight) {
        petBinaryTree.addValue(petName, petWeight);
        return petBinaryTree.getRoot();
    }

    @Override
    public PetNode getTreeAsSet() {
        //TODO
        return null;
    }
}
