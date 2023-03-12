package hu.mpb.backendpetproject.controller;

import hu.mpb.backendpetproject.controller.dto.PetNodeDto;
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
    private ResponseEntity<PetNodeDto> getTestTree() {
        return new ResponseEntity<>(
                petService.getPetNodeDto(UUID.randomUUID()),
                HttpStatus.OK
        );
        /*return new ResponseEntity<>(HttpStatus.NO_CONTENT);*/
    }

    @PutMapping(value = "/test", produces = "application/json")
    private ResponseEntity<PetNodeDto> putPetNode(@RequestBody String petName, @RequestBody int petWeight) {
        PetNodeDto result = petService.insertPet(UUID.randomUUID(), petName, petWeight);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
