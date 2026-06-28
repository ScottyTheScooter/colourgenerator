package de.dhbwravensburg.webeng.colourgenproject.exception;

public class GeneratedPaletteNotFoundException  extends RuntimeException{

    public GeneratedPaletteNotFoundException(Long id){
        super("Palette with id" + id + " not found");
    }

}
