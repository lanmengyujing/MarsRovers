package command;

import MarsRover.Rover;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-7
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */
public abstract class Command {
    Rover rover;

    public Command(Rover rover) {
        this.rover = rover;
    }

    public abstract void action();
}
