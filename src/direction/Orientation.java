package direction;

import MarsRover.Rover;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 */
public interface Orientation {

    public void forward(Rover rover);

    public Orientation turnLeft();

    public Orientation turnRight();

    public char orientationName();
}
