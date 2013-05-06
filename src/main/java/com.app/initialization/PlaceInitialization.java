package com.app.initialization;

import com.app.exception.GameException;
import com.app.exception.OutOfBoundException;
import com.app.game.Rover;
import com.app.parser.PlaceParser;

public class PlaceInitialization extends InitCommand {
    private Rover rover;

    public PlaceInitialization(String command, Rover rover) {
        super(command);
        this.rover = rover;
    }

    @Override
    public void configure() throws GameException {
        PlaceParser parser = new PlaceParser();
        parser.parse(command);
        if (rover.isInPlateau(parser.getPosX(), parser.getPosY())) {
            rover.setPosX(parser.getPosX());
            rover.setPosY(parser.getPosY());
            rover.setOrientation(parser.getOrientation());
        } else {
            throw new OutOfBoundException(OutOfBoundException.OUT_OF_BOUND);
        }
    }
}
