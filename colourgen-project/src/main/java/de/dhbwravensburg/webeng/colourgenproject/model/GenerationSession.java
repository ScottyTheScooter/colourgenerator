package de.dhbwravensburg.webeng.colourgenproject.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class GenerationSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paletteGeneratorName;
    private LocalDateTime generatedAt;
    private String paletteName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "generated_palette_id")
    private GeneratedPalette generatedPalette;;

    protected GenerationSession() {}

    public GenerationSession(String paletteName, LocalDateTime generatedAt, String paletteGeneratorName, GeneratedPalette generatedPalette) {
        this.generatedAt = generatedAt;
        this.paletteName = paletteName;
        this.paletteGeneratorName = paletteGeneratorName;
        this.generatedPalette = generatedPalette;
    }

    public Long getId() {
        return id;
    }

    public String getPaletteGeneratorName() {
        return paletteGeneratorName;
    }
    public void setPaletteGeneratorName(String v) {
        this.paletteGeneratorName = v;
    }

    public LocalDateTime getGeneratedAt() {
        return  generatedAt;
    }
    public void setGeneratedAt(LocalDateTime v) {
        this.generatedAt = v;
    }

    public String getPaletteName() {
        return paletteName;
    }
    public void setPaletteName(String v) {
        this.paletteName = v;
    }

    public GeneratedPalette getGeneratedPalette() {
        return generatedPalette;
    }
    public void setGeneratedPalette(GeneratedPalette v) {
        this.generatedPalette = v;
    }


}
