package com.app.direction;

import com.app.exception.OutOfBoundException;
import com.app.game.Plateau;
import com.app.game.Rover;

public class SState implements State {
    Rover rover;

    public SState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void forward() throws OutOfBoundException {
        if (!Plateau.getInstance().isInRange(rover.getPosX(), rover.getPosY() - 1 )){
            throw new OutOfBoundException();
        }
        rover.setPosY(rover.getPosY() - 1);
    }

    @Override
    public State turnLeft() {
        return new EState(rover);
    }

    @Override
    public State turnRight() {
        return new WState(rover);
    }

    @Override
    public char orientationName() {
        return 'S';
    }
}
