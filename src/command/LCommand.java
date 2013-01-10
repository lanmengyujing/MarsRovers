package command;

import MarsRover.Rover;
import direction.*;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 */
public class LCommand extends Command {
    public LCommand(Rover rover) {
        super(rover);
    }

    @Override
    public void action() {
        Orientation orientation = rover.getOrientation();
        rover.setOrientation(orientation.turnLeft());
    }
}
