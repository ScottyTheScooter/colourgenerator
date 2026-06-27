package de.dhbwravensburg.webeng.colourgenproject.mapper;

import de.dhbwravensburg.webeng.colourgenproject.dto.GeneratedPaletteRequest;
import de.dhbwravensburg.webeng.colourgenproject.dto.GeneratedPaletteResponse;
import de.dhbwravensburg.webeng.colourgenproject.model.GeneratedPalette;

public final class GeneratedPaletteMapper {

    private GeneratedPaletteMapper() {}

    public static GeneratedPalette toEntity(Long id, GeneratedPaletteRequest request) {
        return new GeneratedPalette(
                id,
                request.hexCode(),
                request.rgbCode(),
                request.hslCode(),
                request.hsvCode(),
                request.colorName(),
                request.cmykValue(),
                request.seedHexCode(),
                request.achrome()
        );
    }

    public static GeneratedPaletteResponse toResponse(GeneratedPalette entity) {
        return new GeneratedPaletteResponse(
                entity.getId(),
                entity.getHexCode(),
                entity.getRgbCode(),
                entity.getHslCode(),
                entity.getHsvCode(),
                entity.getColorName(),
                entity.getCmykValue(),
                entity.getSeedHexCode(),
                entity.isAchrome()
        );
    }

}
