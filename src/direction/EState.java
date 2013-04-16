package direction;

import exception.OutOfBoundException;
import Game.Plateau;
import Game.Rover;

public class EState implements State {
    Rover rover;

    public EState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void forward() {
        if (!Plateau.getInstance().isInRange(rover.getPosX() + 1, rover.getPosY())){
            throw new OutOfBoundException();
        }
        rover.setPosX(rover.getPosX() + 1);
    }

    @Override
    public void turnLeft() {
        rover.setOrientation( new NState(rover));
    }

    @Override
    public void turnRight() {
        rover.setOrientation( new SState(rover));
    }

    @Override
    public char orientationName(){
        return 'E';
    }
}
