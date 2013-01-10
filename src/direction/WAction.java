package direction;

import MarsRover.OutOfBoundException;
import MarsRover.Plateau;
import MarsRover.Rover;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午10:34
 * To change this template use File | Settings | File Templates.
 */
public class WAction implements Orientation {
    @Override
    public void forward(Rover rover) {
        if (!Plateau.getInstance().isInRange(rover.getPosX() - 1, rover.getPosY())){
            throw new OutOfBoundException();
        }
        rover.setPosX(rover.getPosX() - 1);
    }

    @Override
    public Orientation turnLeft() {
        return new SAction();
    }

    @Override
    public Orientation turnRight() {
        return new NAction();
    }

    @Override
    public char orientationName(){
        return 'W';
    }
}
