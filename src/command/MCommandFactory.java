package command;

import MarsRover.Rover;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午9:49
 * To change this template use File | Settings | File Templates.
 */
public class MCommandFactory extends AbstractFactory {
    @Override
    public Command createCommand(Rover rover) {
        return new MCommand(rover);
    }
}
