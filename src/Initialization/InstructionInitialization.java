package Initialization;

import Game.Rover;
import exception.GameException;
import parser.InstructionParser;

public class InstructionInitialization extends InitCommand {
    private Rover rover;

    public InstructionInitialization(String command, Rover rover) {
        super(command);
        this.rover = rover;
    }

    @Override
    public void configure() throws GameException{
        InstructionParser parser = new InstructionParser();
        parser.parse(command);
        rover.setInstruction(parser.getInsruction());
    }
}
