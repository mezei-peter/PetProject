package hu.mpb.backendpetproject.service.pet;

import hu.mpb.backendpetproject.model.PetNode;

import java.util.UUID;

public interface PetService {
    public PetNode getPetNode();

    PetNode insertPet(UUID randomUUID, String petName, int petWeight);

    PetNode getTreeAsSet();
}
