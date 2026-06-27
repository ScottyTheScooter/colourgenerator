package de.dhbwravensburg.webeng.colourgenproject.service;

import de.dhbwravensburg.webeng.colourgenproject.model.GeneratedPalette;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GeneratedPaletteService {

    private final ConcurrentHashMap<Long, GeneratedPalette> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public GeneratedPaletteService() {
        // Seed data
        create(new GeneratedPalette(null, "#000000", "rgb(0,0,0)", "hsl(0,0,0)", "hsv(0,0,0)", "Black", "cmyk(0,0,0,100)", "#000000", true));
        create(new GeneratedPalette(null, "#ffffff", "rgb(255,255,255)", "hsl(0,0,100)", "hsv(0,0,100)", "White", "cmyk(0,0,0,0)", "#000000", true));
        create(new GeneratedPalette(null, "#ff0000", "rgb(255,0,0)", "hsl(0,50,50)", "hsv(0,50,50)", "Bright Red", "cmyk(0,100,100,0)", "#000000", false));
    }

    public List<GeneratedPalette> findAll() {
        return List.copyOf(store.values());
    }

    public Optional<GeneratedPalette> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public GeneratedPalette create(GeneratedPalette entity) {
        Long newId = idGenerator.getAndIncrement();
        entity.setId(newId);
        store.put(newId, entity);
        return entity;
    }

    public Optional<GeneratedPalette> update(Long id, GeneratedPalette entity) {
        if (!store.containsKey(id)) {
            return Optional.empty();
        }
        entity.setId(id);
        store.put(id, entity);
        return Optional.of(entity);
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}
