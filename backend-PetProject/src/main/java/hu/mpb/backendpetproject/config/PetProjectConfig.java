package hu.mpb.backendpetproject.config;

import hu.mpb.backendpetproject.service.dtoConverter.PetNodeConverter;
import hu.mpb.backendpetproject.service.dtoConverter.PetNodeConverterImpl;
import hu.mpb.backendpetproject.service.pet.DevPetService;
import hu.mpb.backendpetproject.service.pet.PetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetProjectConfig {
    @Bean
    public PetNodeConverter petNodeConverter() {
        return new PetNodeConverterImpl();
    }
    @Bean
    public PetService petService(PetNodeConverter petNodeConverter) {
        return new DevPetService(petNodeConverter);
    }
}
