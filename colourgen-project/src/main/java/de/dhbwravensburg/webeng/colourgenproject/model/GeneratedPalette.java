package de.dhbwravensburg.webeng.colourgenproject.model;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GeneratedPalette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hexCode;
    private String rgbCode;
    private String hslCode;
    private String hsvCode;
    private String colorName;
    private String cmykValue;
    private String seedHexCode;
    private boolean achrome;

    protected GeneratedPalette() {
        // Empty
    }

    public GeneratedPalette(
            Long id, String hexCode, String rgbCode, String hslCode,
            String hsvCode, String colorName, String cmykValue,
            String seedHexCode, boolean achrome) {
        this.id = id;
        this.hexCode = hexCode;
        this.rgbCode = rgbCode;
        this.hslCode = hslCode;
        this.hsvCode = hsvCode;
        this.colorName = colorName;
        this.cmykValue = cmykValue;
        this.seedHexCode = seedHexCode;
        this.achrome = achrome;
    }

    @OneToMany(mappedBy = "generatedPalette",
                cascade = CascadeType.ALL,
                orphanRemoval = true,
                fetch = FetchType.LAZY)
    private List<GenerationSession> generations = new ArrayList<>();

    public List<GenerationSession> getGenerated() {
        return generations;
    }

    public void addGeneration(GenerationSession generation) {
        generations.add(generation);
        generation.setGeneratedPalette(this);
    }

    public void removeGeneration(GenerationSession generation) {
        generations.remove(generation);
        generation.setGeneratedPalette(null);
    }

    //Getter and Setters
    public Long getId() { return id; }

    public String getHexCode() { return hexCode; }
    public void setHexCode(String v) { this.hexCode = v; }

    public String getRgbCode() { return rgbCode; }
    public void setRgbCode(String v) { this.rgbCode = v; }

    public String getHslCode() { return hslCode; }
    public void setHslCode(String v) { this.hslCode = v; }

    public String getHsvCode() { return hsvCode; }
    public void setHsvCode(String v) { this.hsvCode = v; }

    public String getColorName() { return colorName; }
    public void setColorName(String colorName) { this.colorName = colorName; }

    public String getCmykValue() { return cmykValue; }
    public void setCmykValue(String v) { this.cmykValue = v; }

    public String getSeedHexCode() { return seedHexCode; }
    public void setSeedHexCode(String v) { this.seedHexCode = v; }

    public boolean notAchrome() { return achrome; }
    public void setAchrome(boolean v) { this.achrome = v; }

}