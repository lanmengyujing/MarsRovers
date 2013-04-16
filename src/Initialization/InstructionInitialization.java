package Initialization;

import Game.Rover;
import parser.InstructionParser;

public class InstructionInitialization extends InitCommand {
    private Rover rover;

    public InstructionInitialization(String command, Rover rover) {
        super(command);
        this.rover = rover;
    }

    @Override
    public void configure() {
        InstructionParser parser = new InstructionParser();
        parser.parse(command);
        rover.setInstruction(parser.getInsruction());
    }
}
