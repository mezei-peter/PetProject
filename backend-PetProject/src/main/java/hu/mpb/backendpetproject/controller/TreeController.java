package hu.mpb.backendpetproject.controller;

import hu.mpb.backendpetproject.controller.dto.NewPetDto;
import hu.mpb.backendpetproject.model.PetNode;
import hu.mpb.backendpetproject.service.pet.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("tree")
public class TreeController {
    private final PetService petService;

    public TreeController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(value = "/test", produces = "application/json")
    private ResponseEntity<PetNode> getTestTree(@RequestParam(required = false) String convert) {
        PetNode result = null;
        if (convert != null) {
            switch (convert) {
                case "set" -> {
                    result = petService.getTreeAsSet();
                }
                default -> {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }
        } else {
            result = petService.getPetNode();
        }

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(
                result,
                HttpStatus.OK
        );
    }

    @PutMapping(value = "/test", produces = "application/json")
    private ResponseEntity<PetNode> putPetNode(@RequestBody NewPetDto newPetDto) {
        String petName = newPetDto.petName();
        int petWeight = newPetDto.petWeight();
        PetNode result = petService.insertPet(UUID.randomUUID(), petName, petWeight);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
