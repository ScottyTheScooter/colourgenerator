package de.dhbwravensburg.webeng.colourgenproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NeoPalette(
        String id,
        String colourName,
        String hexCode,
        String
) {
}
