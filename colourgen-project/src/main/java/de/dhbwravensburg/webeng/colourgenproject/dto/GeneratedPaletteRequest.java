package de.dhbwravensburg.webeng.colourgenproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GeneratedPaletteRequest(

        @NotBlank(message = "hex code must not be blank")
        String hexCode,

        String rgbCode,
        String hslCode,
        String hsvCode,

        @NotBlank(message = "name must not be blank")
        @Size(max = 100, message = "name must be at most 100 characters")
        String name,

        String colorName,
        String cmykValue,
        String seedHexCode,
        boolean achrome
) {}
