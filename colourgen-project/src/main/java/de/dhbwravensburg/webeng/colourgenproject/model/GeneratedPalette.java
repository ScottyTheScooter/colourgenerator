package de.dhbwravensburg.webeng.colourgenproject.model;

public class GeneratedPalette {

    private Long id;
    private String hexCode;
    private String rgbCode;
    private String hslCode;
    private String hsvCode;
    private String colorName;
    private String cmykValue;
    private String seedHexCode;

    public GeneratedPalette() {}

    public GeneratedPalette(Long id, String hexCode, String rgbCode, String hslCode, String hsvCode, String colorName, String cmykValue, String seedHexCode) {
        this.id = id;
        this.hexCode = hexCode;
        this.rgbCode = rgbCode;
        this.hslCode = hslCode;
        this.hsvCode = hsvCode;
        this.colorName = colorName;
        this.cmykValue = cmykValue;
        this.seedHexCode = seedHexCode;
    }

    //Getter and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRgbCode() { return rgbCode; }
    public void setRgbCode(String rgbCode) { this.rgbCode = rgbCode; }

    public String hslCode() { return hslCode; }
    public void setHslCode(String hslCode) { this.hslCode = hslCode; }

    public String getHsvCode() { return hsvCode; }
    public void setHsvCode(String hsvCode) { this.hsvCode = hsvCode; }

    public String getColorName() { return colorName; }
    public void setColorName(String colorName) { this.colorName = colorName; }

    public String getCmykValue() { return cmykValue; }
    public void setCmykValue(String cmykValue) { this.cmykValue = cmykValue; }

    public String getSeedHexCode() { return seedHexCode; }
    public void setSeedHexCode(String seedHexCode) { this.seedHexCode = seedHexCode; }

}
