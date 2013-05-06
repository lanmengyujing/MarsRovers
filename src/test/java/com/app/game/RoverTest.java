package com.app.game;


import com.app.exception.OutOfBoundException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoverTest {
    Rover rover;
    Plateau plateau;

    @Before
    public void setup() {
        rover = new Rover("Iran", 0, 0, 'N');
        plateau = mock(Plateau.class);
        when(plateau.getUpperX()).thenReturn(5);
        when(plateau.getUpperY()).thenReturn(5);
        when(plateau.isInRange(0, 1)).thenReturn(true);
        rover.setPlateau(plateau);
    }

    @Test
    public void should_set_attributes_of_a_rover() {
        rover = new Rover("Tom", 5, 4, 's');
        assertThat(rover.getName(), equalTo("Tom"));
        assertThat(rover.getPosX(), is(5));
        assertThat(rover.getPosY(), is(4));
        assertThat(rover.getOrientation().orientationName(), is('S'));
    }

    @Test
    public void should_Instruction_Be_LMMR_When_SetInstruction_LMMR() {
        rover.setInstruction("LMMR");
        assertThat(rover.getInstruction(), equalTo("LMMR"));
    }

    @Test
    public void should_Orientation_Be_W_When_Command_is_L() throws OutOfBoundException {
        rover.operation('L');
        assertThat(rover.getOrientation().orientationName(), is('W'));
    }

    @Test
    public void should_Orientation_Be_E_When_Command_is_R() throws OutOfBoundException {
        rover.operation('r');
        assertThat(rover.getOrientation().orientationName(), is('E'));
    }

    @Test
    public void should_PosY_Be_1_When_Command_is_M() throws OutOfBoundException {
        rover.operation('m');
        assertThat(rover.getPosY(), is(1));
    }

    @Test
    public void should_print_RIP_when_rover_is_out_bound() {
        rover = new Rover("Ton", -2, 0, 'N');
        rover.setPlateau(plateau);
        assertThat(rover.toString(), equalTo("-2 0 N RIP"));
    }

}


