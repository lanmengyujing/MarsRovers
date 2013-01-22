package Initialization;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-19
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */
public abstract class InitCommand {
    String command;

    public InitCommand(String command) {
        this.command = command;
    }

    public abstract void configure();

}
