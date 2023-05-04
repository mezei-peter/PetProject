package hu.mpb.backendpetproject.service.pet;

import hu.mpb.backendpetproject.model.pettree.PetNode;

import java.util.Set;
import java.util.UUID;

public interface PetService {
    public PetNode getTreeRoot();

    PetNode insertPet(UUID randomUUID, String petName, int petWeight);

    Set<PetNode> getTreeAsSet();

    void deleteNode(UUID uuid);
}
