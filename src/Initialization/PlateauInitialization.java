package Initialization;

import Game.Plateau;
import parser.PlateauParser;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-19
 * Time: 下午9:29
 * To change this template use File | Settings | File Templates.
 */
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
