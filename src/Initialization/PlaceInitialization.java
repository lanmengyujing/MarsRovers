package Initialization;

import exception.OutOfBoundException;
import Game.Plateau;
import Game.Rover;
import parser.PlaceParser;

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
