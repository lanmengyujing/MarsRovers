package com.app.direction;

import com.app.exception.OutOfBoundException;
import com.app.game.Plateau;
import com.app.game.Rover;

public class EState implements State {
    Rover rover;

    public EState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void forward() throws OutOfBoundException {
        if (!Plateau.getInstance().isInRange(rover.getPosX() + 1, rover.getPosY())){
            throw new OutOfBoundException();
        }
        rover.setPosX(rover.getPosX() + 1);
    }

    @Override
    public State turnLeft() {
        return new NState(rover);
    }

    @Override
    public State turnRight() {
        return new SState(rover);
    }

    @Override
    public char orientationName(){
        return 'E';
    }
}
