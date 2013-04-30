package com.app.direction;

import com.app.exception.OutOfBoundException;
import com.app.game.Plateau;
import com.app.game.Rover;

public class WState implements State {
    Rover rover;

    public WState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void forward() throws OutOfBoundException {
        if (!Plateau.getInstance().isInRange(rover.getPosX() - 1, rover.getPosY())){
            throw new OutOfBoundException(OutOfBoundException.OUT_OF_BOUND);
        }
        rover.setPosX(rover.getPosX() - 1);
    }

    @Override
    public State turnLeft() {
        return new SState(rover);
    }

    @Override
    public State turnRight() {
        return new NState(rover);
    }

    @Override
    public char orientationName(){
        return 'W';
    }
}
