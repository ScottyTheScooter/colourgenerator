package de.dhbwravensburg.webeng.colourgenproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {

    @RequestMapping("/api/info")
    public Map<String, String> info() {
        return Map.of(
                "name", "ColourGen",
                "version", "0.1.0"
        );
    }

}
