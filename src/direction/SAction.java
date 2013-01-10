package direction;

import MarsRover.OutOfBoundException;
import MarsRover.Plateau;
import MarsRover.Rover;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午10:30
 * To change this template use File | Settings | File Templates.
 */
public class SAction implements Orientation {
    @Override
    public void forward(Rover rover) {
        if (!Plateau.getInstance().isInRange(rover.getPosX(), rover.getPosY() - 1 )){
            throw new OutOfBoundException();
        }
        rover.setPosY(rover.getPosY() - 1);
    }

    @Override
    public Orientation turnLeft() {
        return new EAction();
    }

    @Override
    public Orientation turnRight() {
        return new WAction();
    }

    @Override
    public char orientationName() {
        return 'S';
    }
}
