package hu.mpb.backendpetproject.service.pet;

import hu.mpb.backendpetproject.controller.dto.PetNodeDto;

import java.util.UUID;

public class DevPetService implements PetService {
    private final PetNodeDto currentPetNodeDto = new PetNodeDto(
            "Root",
            30,
            new PetNodeDto("Left", 20, null, null),
            new PetNodeDto("Right", 60,
                    new PetNodeDto(
                            "Right-Left", 40, null, null
                    ),
                    new PetNodeDto("Right-Right", 70,
                            null,
                            new PetNodeDto("Right-Right-Right", 80, null, null)
                    )
            )
    );

    @Override
    public PetNodeDto getPetNodeDto(UUID petNodeId) {
        return currentPetNodeDto;
    }
}
