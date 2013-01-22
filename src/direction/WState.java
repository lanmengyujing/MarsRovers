package direction;

import Game.OutOfBoundException;
import Game.Plateau;
import Game.Rover;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午10:34
 * To change this template use File | Settings | File Templates.
 */
public class WState implements State {
    Rover rover;

    public WState(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void forward() {
        if (!Plateau.getInstance().isInRange(rover.getPosX() - 1, rover.getPosY())){
            throw new OutOfBoundException();
        }
        rover.setPosX(rover.getPosX() - 1);
    }

    @Override
    public void turnLeft() {
        rover.setOrientation(new SState(rover));
    }

    @Override
    public void turnRight() {
        rover.setOrientation(new NState(rover));
    }

    @Override
    public char orientationName(){
        return 'W';
    }
}
