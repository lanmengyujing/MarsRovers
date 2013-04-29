package com.app.initialization;

import com.app.exception.GameException;
import com.app.game.Plateau;
import com.app.parser.PlateauParser;

public class PlateauInitialization extends InitCommand {

    public PlateauInitialization(String command) {
        super(command);
    }

    @Override
    public void configure() throws GameException {
        PlateauParser parser = new PlateauParser();
        parser.parse(command);
        Plateau.getInstance().setUpperX(parser.getUpperX());
        Plateau.getInstance().setUpperY(parser.getUpperY());
    }
}
