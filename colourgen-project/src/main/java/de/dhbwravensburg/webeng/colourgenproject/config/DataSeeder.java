package de.dhbwravensburg.webeng.colourgenproject.config;

import de.dhbwravensburg.webeng.colourgenproject.model.GeneratedPalette;
import de.dhbwravensburg.webeng.colourgenproject.repository.GeneratedPaletteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedGeneratedPalettes(GeneratedPaletteRepository repository) {
        return args -> {
            if(repository.count() > 0) {
                return;
            }
            repository.save(new GeneratedPalette(null, "#000000", "rgb(0,0,0)", "hsl(0,0,0)", "hsv(0,0,0)", "Black", "cmyk(0,0,0,100)", "#000000", true));
            repository.save(new GeneratedPalette(null, "#ffffff", "rgb(255,255,255)", "hsl(0,0,100)", "hsv(0,0,100)", "White", "cmyk(0,0,0,0)", "#000000", true));
            repository.save(new GeneratedPalette(null, "#ff0000", "rgb(255,0,0)", "hsl(0,50,50)", "hsv(0,50,50)", "Bright Red", "cmyk(0,100,100,0)", "#000000", false));
        };
    }
}
