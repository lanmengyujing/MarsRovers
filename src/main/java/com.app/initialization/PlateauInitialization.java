package com.app.initialization;

import com.app.exception.GameException;
import com.app.game.Plateau;
import com.app.parser.PlateauParser;

public class PlateauInitialization extends InitCommand {
    private Plateau plateau;


    public Plateau getPlateau() {
        return plateau;
    }
    public PlateauInitialization(String command, Plateau plateau) {
        super(command);
        this.plateau = plateau;
    }

    @Override
    public void configure() throws GameException {
        PlateauParser parser = new PlateauParser();
        parser.parse(command);
        plateau.setUpperX(parser.getUpperX());
        plateau.setUpperY(parser.getUpperY());
    }
}
