package command;

import MarsRover.Rover;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午9:18
 * To change this template use File | Settings | File Templates.
 */
public class LCommandFactory extends AbstractFactory {

    @Override
    public Command createCommand(Rover rover) {
        return new LCommand(rover);
    }
}
