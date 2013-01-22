package Initialization;

import Game.Rover;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-20
 * Time: 上午10:39
 * To change this template use File | Settings | File Templates.
 */
public class InstructionInitializationTest {
    @Test
    public void should_instruction_be_MRML_when_input_mrml() {
        Rover rover = new Rover();
        InstructionInitialization initialization = new InstructionInitialization("mrml", rover);
        initialization.configure();
        assertThat(rover.getInstruction(), is("MRML"));
    }
}
