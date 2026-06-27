package de.dhbwravensburg.webeng.colourgenproject.controller;

import de.dhbwravensburg.webeng.colourgenproject.model.GeneratedPalette;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/generated-palettes")
public class GeneratedPaletteController {

    // Data will be replaced later
    private final List<GeneratedPalette> generatedPalettes = List.of(
            new GeneratedPalette(1L, "#ff0000", "rgb(225,0,0)", "hsl(0,100,50)", "hsv(0,100,50)", "Bright Red", "cmyk(0,100,100,0)", "#000000", false),
            new GeneratedPalette(2L, "#00ff00", "rgb(0,255,0)", "hsl(0,120,50)", "hsv(0,120,50)", "Bright Green", "cmyk(100,0,100,0)", "#000000", false),
            new GeneratedPalette(3L, "#0000ff", "rgb(0,0,255)", "hsl(0,240,50)", "hsv(0,240,50)", "Bright Blue", "cmyk(100,100,0,0)", "#000000", false),
            new GeneratedPalette(4L, "#AAAAAA", "rgb(234,234,234)", "hsl(0,0,92)", "hsv(0,0,92)", "Darkish White", "cmyk(0,0,0,10)", "#000000", true)
    );

    @GetMapping
    public List<GeneratedPalette> getAll() {
        return generatedPalettes;
    }

    @GetMapping("/{id}")
    public GeneratedPalette getById(@PathVariable Long id) {
        return generatedPalettes.stream()
                .filter(obj -> obj.getId().equals(id))
                .findFirst()
                .orElse(null); //Will be replaced later
    }

    @GetMapping("/achrome-colors")
    public List<GeneratedPalette> getAchromeColors() {
        return generatedPalettes.stream()
                .filter(GeneratedPalette::isAchrome)
                .toList();
    }

    @GetMapping("/count")
    public int getCount() {
        return generatedPalettes.size();
    }

}
