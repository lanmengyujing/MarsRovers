package command;

import MarsRover.OutOfBoundException;
import MarsRover.Rover;
import direction.Orientation;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */
public class MCommand extends Command {
    public MCommand(Rover rover) {
        super(rover);
    }

    @Override
    public void action() {
        Orientation orientation = rover.getOrientation();
        try {
            orientation.forward(rover);
        } catch (OutOfBoundException e) {
            e.printStackTrace();
        }
    }
}
