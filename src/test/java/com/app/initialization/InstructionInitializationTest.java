package com.app.initialization;

import com.app.exception.GameException;
import com.app.game.Rover;
import com.app.parser.InstructionParser;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InstructionInitializationTest {
    @Test
    public void should_instruction_be_MRML_when_input_mrml() throws GameException{
        Rover rover = new Rover();
        InstructionInitialization initialization = new InstructionInitialization("mrml", rover);
        InstructionParser parser = mock(InstructionParser.class);
        when(parser.getInstruction()).thenReturn("MRML");
        initialization.configure();
        assertThat(rover.getInstruction(), is("MRML"));
    }


}
