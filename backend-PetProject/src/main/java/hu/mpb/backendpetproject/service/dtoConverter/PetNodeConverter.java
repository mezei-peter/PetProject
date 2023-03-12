package hu.mpb.backendpetproject.service.dtoConverter;

import hu.mpb.backendpetproject.controller.dto.PetNodeDto;
import hu.mpb.backendpetproject.model.PetNode;

public interface PetNodeConverter {
    public PetNodeDto convertPetNodeToDto(PetNode petNode);
}
