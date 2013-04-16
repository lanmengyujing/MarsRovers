package Initialization;

public abstract class InitCommand {
    String command;

    public InitCommand(String command) {
        this.command = command;
    }

    public abstract void configure();

}
