package hu.mpb.backendpetproject.controller;

import hu.mpb.backendpetproject.controller.dto.NewPetDto;
import hu.mpb.backendpetproject.model.PetNode;
import hu.mpb.backendpetproject.service.pet.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("tree")
public class TreeController {
    private final PetService petService;

    public TreeController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(value = "/test", produces = "application/json")
    private ResponseEntity<PetNode> getTestTree() {
        PetNode result = petService.getPetNode();
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(
                result,
                HttpStatus.OK
        );
    }

    @GetMapping(value = "test/set", produces = "application/json")
    private ResponseEntity<Set<PetNode>> getTestTreeAsSet() {
        Set<PetNode> result = petService.getTreeAsSet();
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "/test", produces = "application/json")
    private ResponseEntity<PetNode> putPetNode(@RequestBody NewPetDto newPetDto) {
        String petName = newPetDto.petName();
        int petWeight = newPetDto.petWeight();
        PetNode result = petService.insertPet(UUID.randomUUID(), petName, petWeight);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "/test/{petNodeId}", produces = "application/json")
    private ResponseEntity<PetNode> deletePetNodeAndGetNewRoot(@PathVariable String petNodeId) {
        UUID uuid;
        try {
            uuid = UUID.fromString(petNodeId);
        } catch (Throwable e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        petService.deleteNode(uuid);
        return getTestTree();
    }
}
