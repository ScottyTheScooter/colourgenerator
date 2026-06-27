package de.dhbwravensburg.webeng.colourgenproject.dto;

public record GeneratedPaletteRequest(
        String hexCode,
        String rgbCode,
        String hslCode,
        String hsvCode,
        String colorName,
        String cmykValue,
        String seedHexCode,
        boolean achrome
) {}
