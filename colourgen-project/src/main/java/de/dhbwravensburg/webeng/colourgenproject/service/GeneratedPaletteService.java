package de.dhbwravensburg.webeng.colourgenproject.service;

import de.dhbwravensburg.webeng.colourgenproject.exception.GeneratedPaletteNotFoundException;
import de.dhbwravensburg.webeng.colourgenproject.model.GeneratedPalette;
import de.dhbwravensburg.webeng.colourgenproject.repository.GeneratedPaletteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneratedPaletteService {

    private final GeneratedPaletteRepository repository;

    public GeneratedPaletteService(GeneratedPaletteRepository repository) {
        this.repository = repository;
    }

    public List<GeneratedPalette> findAll() {
        return repository.findAll();
    }

    public Optional<GeneratedPalette> findById(Long id) {
        return repository.findById(id);
    }
    public GeneratedPalette getOrThrow(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new GeneratedPaletteNotFoundException(id));
    }

//    public Optional<GeneratedPalette> findAchrome() {
//        return repository.findByAchrome(true);
//    }

    public GeneratedPalette create(GeneratedPalette entity) {
        return repository.save(entity);
    }

    public Optional<GeneratedPalette> update(Long id, GeneratedPalette updated) {
        return repository.findById(id).map(existing -> {
            existing.setAchrome(updated.notAchrome());
            existing.setHexCode(updated.getHexCode());
            existing.setRgbCode(updated.getRgbCode());
            existing.setHslCode(updated.getHslCode());
            existing.setHsvCode(updated.getHsvCode());
            existing.setColorName(updated.getColorName());
            existing.setCmykValue(updated.getCmykValue());
            existing.setSeedHexCode(updated.getSeedHexCode());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if(!repository.existsById(id)) {
            throw new GeneratedPaletteNotFoundException(id);
        }
        repository.deleteById(id);
        return false;
    }

//    public GeneratedPaletteService() {
//        // Seed data
//        create(new GeneratedPalette(null, "#000000", "rgb(0,0,0)", "hsl(0,0,0)", "hsv(0,0,0)", "Black", "cmyk(0,0,0,100)", "#000000", true));
//        create(new GeneratedPalette(null, "#ffffff", "rgb(255,255,255)", "hsl(0,0,100)", "hsv(0,0,100)", "White", "cmyk(0,0,0,0)", "#000000", true));
//        create(new GeneratedPalette(null, "#ff0000", "rgb(255,0,0)", "hsl(0,50,50)", "hsv(0,50,50)", "Bright Red", "cmyk(0,100,100,0)", "#000000", false));
//    }
}
