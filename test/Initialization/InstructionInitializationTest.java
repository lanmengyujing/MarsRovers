package Initialization;

import Game.Rover;
import exception.GameException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InstructionInitializationTest {
    @Test
    public void should_instruction_be_MRML_when_input_mrml() throws GameException{
        Rover rover = new Rover();
        InstructionInitialization initialization = new InstructionInitialization("mrml", rover);
        initialization.configure();
        assertThat(rover.getInstruction(), is("MRML"));
    }
}
