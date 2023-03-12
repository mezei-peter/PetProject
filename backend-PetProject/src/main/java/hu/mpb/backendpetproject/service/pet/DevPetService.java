package hu.mpb.backendpetproject.service.pet;

import hu.mpb.backendpetproject.controller.dto.PetNodeDto;
import hu.mpb.backendpetproject.model.PetBinaryTree;
import hu.mpb.backendpetproject.service.binarytree.SimplePetBinaryTreeService;
import hu.mpb.backendpetproject.service.dtoConverter.PetNodeConverter;

import java.util.UUID;

public class DevPetService implements PetService {
    private final PetNodeConverter petNodeConverter;
    private final PetBinaryTree petBinaryTree = new PetBinaryTree(new SimplePetBinaryTreeService());

    public DevPetService(PetNodeConverter petNodeConverter) {
        this.petNodeConverter = petNodeConverter;
    }

    @Override
    public PetNodeDto getPetNodeDto(UUID petNodeId) {
        if (petBinaryTree.getRoot() == null) {
            return null;
        }
        return petNodeConverter.convertPetNodeToDto(petBinaryTree.getRoot());
    }

    @Override
    public PetNodeDto insertPet(UUID randomUUID, String petName, int petWeight) {
        petBinaryTree.addValue(petName, petWeight);
        return petNodeConverter.convertPetNodeToDto(petBinaryTree.getRoot());
    }
}
