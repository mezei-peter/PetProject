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
                        50,
                        new PetNodeDto("Left", 20, null, null),
                        new PetNodeDto("Right", 60, null, null)
                ),
                HttpStatus.OK
        );
    }
}
