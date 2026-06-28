package de.dhbwravensburg.webeng.colourgenproject.repository;

import de.dhbwravensburg.webeng.colourgenproject.model.GenerationSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenerationSessionRepository extends JpaRepository<GenerationSession, Long> {

    List<GenerationSession> findByGeneratedPaletteId(Long generatedPaletteId);

}
