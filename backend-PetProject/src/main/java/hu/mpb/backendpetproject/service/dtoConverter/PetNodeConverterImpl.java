package hu.mpb.backendpetproject.service.dtoConverter;

import hu.mpb.backendpetproject.controller.dto.PetNodeDto;
import hu.mpb.backendpetproject.model.PetNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PetNodeConverterImpl implements PetNodeConverter {
    @Override
    public PetNodeDto convertPetNodeToDto(PetNode petNode) {
        PetNodeDto leftDto = null;
        PetNodeDto rightDto = null;
        PetNode leftNode = petNode.getLeft();
        PetNode rightNode = petNode.getRight();

        if (leftNode != null) {
            leftDto = convertPetNodeToDto(leftNode);
        }
        if (rightNode != null) {
            rightDto = convertPetNodeToDto(rightNode);
        }

        return new PetNodeDto(petNode.getName(), petNode.getWeight(), leftDto, rightDto);
    }

}
