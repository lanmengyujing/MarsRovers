package command;

import MarsRover.Rover;
import direction.Orientation;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
public class RCommand extends Command {
    public RCommand(Rover rover) {
        super(rover);
    }

    @Override
    public void action() {
        Orientation orientation = rover.getOrientation();
        rover.setOrientation(orientation.turnRight());
    }
}
