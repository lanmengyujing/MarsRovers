package direction;

import exception.OutOfBoundException;
import Game.Plateau;
import Game.Rover;

public class NState implements State {
    Rover rover;

    public NState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void forward() throws OutOfBoundException {
        if (!Plateau.getInstance().isInRange(rover.getPosX(), rover.getPosY() + 1 )){
            throw new OutOfBoundException();
        }
        rover.setPosY(rover.getPosY() + 1);
    }

    @Override
    public void turnLeft() {
        rover.setOrientation( new WState(rover));
    }

    @Override
    public void turnRight() {
        rover.setOrientation( new EState(rover));
    }

    @Override
    public char orientationName() {
        return 'N';
    }
}
