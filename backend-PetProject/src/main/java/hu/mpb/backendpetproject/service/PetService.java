package hu.mpb.backendpetproject.service;

import hu.mpb.backendpetproject.controller.dto.PetNodeDto;

import java.util.UUID;

public interface PetService {
    public PetNodeDto getPetNodeDto(UUID petNodeId);
}
