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
