package hu.mpb.backendpetproject.config;

import hu.mpb.backendpetproject.service.pet.DevPetService;
import hu.mpb.backendpetproject.service.pet.PetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetProjectConfig {
    @Bean
    public PetService petService() {
        return new DevPetService();
    }
}
