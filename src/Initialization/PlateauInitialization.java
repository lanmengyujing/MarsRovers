package Initialization;

import Game.Plateau;
import parser.PlateauParser;

public class PlateauInitialization extends InitCommand {

    public PlateauInitialization(String command) {
        super(command);
    }

    @Override
    public void configure() {
        PlateauParser parser = new PlateauParser();
        parser.parse(command);
        Plateau.getInstance().setUpperX(parser.getUpperX());
        Plateau.getInstance().setUpperY(parser.getUpperY());
    }
}
