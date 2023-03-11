package hu.mpb.backendpetproject.controller;

import hu.mpb.backendpetproject.controller.dto.PetNodeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tree")
public class TreeController {
    @GetMapping(value = "/test", produces = "application/json")
    private ResponseEntity<PetNodeDto> getTestTree() {
        return new ResponseEntity<>(
                new PetNodeDto(
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
                ),
                HttpStatus.OK
        );
        /*return new ResponseEntity<>(HttpStatus.NO_CONTENT);*/
    }
}
