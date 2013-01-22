package Initialization;

import Game.Rover;
import parser.InstructionParser;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-19
 * Time: 下午9:41
 * To change this template use File | Settings | File Templates.
 */
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
