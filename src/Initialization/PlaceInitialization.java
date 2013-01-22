package Initialization;

import Game.OutOfBoundException;
import Game.Plateau;
import Game.Rover;
import parser.PlaceParser;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-19
 * Time: 下午9:47
 * To change this template use File | Settings | File Templates.
 */
public class PlaceInitialization extends InitCommand {
    private Rover rover;

    public PlaceInitialization(String command, Rover rover) {
        super(command);
        this.rover = rover;
    }

    @Override
    public void configure() {
        PlaceParser parser = new PlaceParser();
        parser.parse(command);
        if (Plateau.getInstance().isInRange(parser.getPosX(), parser.getPosY())) {
            rover.setPosX(parser.getPosX());
            rover.setPosY(parser.getPosY());
            rover.setOrientation(parser.getOrientation());
        } else {
            throw new OutOfBoundException();
        }
    }
}
