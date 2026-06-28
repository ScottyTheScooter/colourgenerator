package de.dhbwravensburg.webeng.colourgenproject.repository;

import de.dhbwravensburg.webeng.colourgenproject.model.GeneratedPalette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GeneratedPaletteRepository extends JpaRepository<GeneratedPalette,Long> {

    @Query("""
        SELECT t FROM GeneratedPalette t WHERE t.getColorName AND t.notAchrome = true
    """)
    List<GeneratedPalette> findNotAchromePalette();

    @Query(value = "SELECT * FROM generated_palette WHERE seed_hex_code IS '#000000' AND achrome IS true OR seed_hex_code IS '#ffffff' AND achrome IS true")
    List<GeneratedPalette> findAchromeWithBlackOrWhiteSeed();

}
