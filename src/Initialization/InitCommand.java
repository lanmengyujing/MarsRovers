package Initialization;

import exception.GameException;

public abstract class InitCommand {
    String command;

    public InitCommand(String command) {
        this.command = command;
    }

    public abstract void configure() throws GameException;
}
