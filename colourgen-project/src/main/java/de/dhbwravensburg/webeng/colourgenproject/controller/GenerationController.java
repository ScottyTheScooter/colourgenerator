package de.dhbwravensburg.webeng.colourgenproject.controller;

import de.dhbwravensburg.webeng.colourgenproject.model.GeneratedPalette;
import de.dhbwravensburg.webeng.colourgenproject.model.GenerationSession;
import de.dhbwravensburg.webeng.colourgenproject.repository.GeneratedPaletteRepository;
import de.dhbwravensburg.webeng.colourgenproject.repository.GenerationSessionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/generated-palettes/{generatedPaletteId}/generations")
public class GenerationController {

    private final GeneratedPaletteRepository generatedPaletteRepository;
    private final GenerationSessionRepository generationSessionRepository;

    public GenerationController(GeneratedPaletteRepository t, GenerationSessionRepository o) {
        this.generatedPaletteRepository = t;
        this.generationSessionRepository = o;
    }

    public record GenerationRequest(String paletteName, LocalDateTime generatedAt, String paletteGeneratorName) {}

    @GetMapping
    public List<GenerationSession> getAll(@PathVariable Long generatedPaletteId) {
        return generationSessionRepository.findByGeneratedPaletteId(generatedPaletteId);
    }

    @PostMapping
    public ResponseEntity<GenerationSession> create(
            @PathVariable Long generatedPaletteId,
            @RequestBody GenerationRequest request) {
        GeneratedPalette parent = generatedPaletteRepository.findById(generatedPaletteId)
                .orElse(null);
        if (parent == null) {
            return ResponseEntity.notFound().build();
        }
        GenerationSession generation = new GenerationSession(
                request.paletteName(),
                request.generatedAt(),
                request.paletteGeneratorName(),
                parent
        );
        GenerationSession saved = generationSessionRepository.save(generation);
        return ResponseEntity
                .created(URI.create("/api/generated-palettes/" + generatedPaletteId + "/observations/" + saved.getId()))
                .body(saved);
    }

}
