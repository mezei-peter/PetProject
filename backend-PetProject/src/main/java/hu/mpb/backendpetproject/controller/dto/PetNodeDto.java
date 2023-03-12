package hu.mpb.backendpetproject.controller.dto;

public record PetNodeDto (String name, int weight, PetNodeDto leftChild, PetNodeDto rightChild) {
}
