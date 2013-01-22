package direction;

import Game.OutOfBoundException;
import Game.Plateau;
import Game.Rover;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午10:30
 * To change this template use File | Settings | File Templates.
 */
public class SState implements State {
    Rover rover;

    public SState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void forward() {
        if (!Plateau.getInstance().isInRange(rover.getPosX(), rover.getPosY() - 1 )){
            throw new OutOfBoundException();
        }
        rover.setPosY(rover.getPosY() - 1);
    }

    @Override
    public void turnLeft() {
        rover.setOrientation(new EState(rover));
    }

    @Override
    public void turnRight() {
        rover.setOrientation(new WState(rover));
    }

    @Override
    public char orientationName() {
        return 'S';
    }
}
