package de.dhbwravensburg.webeng.colourgenproject.controller;

import de.dhbwravensburg.webeng.colourgenproject.dto.GeneratedPaletteRequest;
import de.dhbwravensburg.webeng.colourgenproject.dto.GeneratedPaletteResponse;
import de.dhbwravensburg.webeng.colourgenproject.mapper.GeneratedPaletteMapper;
import de.dhbwravensburg.webeng.colourgenproject.model.GeneratedPalette;
import de.dhbwravensburg.webeng.colourgenproject.service.GeneratedPaletteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/generated-palettes")
public class GeneratedPaletteController {

    private final GeneratedPaletteService service;

    public GeneratedPaletteController(GeneratedPaletteService service) {
        this.service = service;
    }

    @GetMapping
    public List<GeneratedPaletteResponse> getAll() {
        return service.findAll().stream()
                .map(GeneratedPaletteMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public GeneratedPaletteResponse getById(@PathVariable Long id) {
        return GeneratedPaletteMapper.toResponse(service.getOrThrow(id));
    }

    @PostMapping
    public ResponseEntity<GeneratedPaletteResponse> create(@Valid @RequestBody GeneratedPaletteRequest request) {
        GeneratedPalette created = service.create(GeneratedPaletteMapper.toEntity(null, request));
        GeneratedPaletteResponse response = GeneratedPaletteMapper.toResponse(created);
        return ResponseEntity
                .created(URI.create("/api/generated-palettes/" + created.getId()))
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneratedPaletteResponse> update(@PathVariable Long id, @Valid @RequestBody GeneratedPaletteRequest request) {
        return service.update(id, GeneratedPaletteMapper.toEntity(id, request))
                .map(GeneratedPaletteMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GOTTA FIX THIS LATER
//    @PatchMapping("/{id}/achrome")
//    public ResponseEntity<GeneratedPaletteResponse> toggleAchrome(@PathVariable Long id) {
//        return service.selectAchrome(id)
//                .map(GeneratedPaletteMapper::toResponse)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    //Get all achrome colours
//    @GetMapping("?achrome=true")
//    public ResponseEntity<List<GeneratedPaletteResponse>> getByAchrome(String achrome) {
//        return service.findByAchrome(achrome)
//                .map(GeneratedPaletteMapper::toResponse)
//                .map(ResponseEntity::ok);
//    }

}
