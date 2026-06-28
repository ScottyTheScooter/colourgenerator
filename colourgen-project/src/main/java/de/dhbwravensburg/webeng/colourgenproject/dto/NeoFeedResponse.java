package de.dhbwravensburg.webeng.colourgenproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NeoFeedResponse(
        int element_count,
        Map<String, List<NeoObject>> achrome_palettes
) {
}
