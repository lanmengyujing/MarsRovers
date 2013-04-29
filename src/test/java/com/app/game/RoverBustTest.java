package com.app.game;

import com.app.exception.GameException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RoverBustTest {
    private RoverBust roverBust;
    private Rover rover;
    @Before
    public void setup() throws GameException {
        Plateau.getInstance().setUpperX(5);
        Plateau.getInstance().setUpperY(5);
        roverBust = new RoverBust();
        rover = new Rover();
    }

    @Test
    public void should_Rovers_Crash_When_Input_Rover_1_1_N_Instruction_M_And_Rover_1_3_S_Instruction_M(){
        rover = new Rover(1 , 1, 'n');
        rover.setInstruction("m");
        roverBust.addRover(rover);
        roverBust.runRover(rover);

        Rover roverNext = new Rover(1, 3, 's');
        roverNext.setInstruction("mmlmml");
        roverBust.addRover(roverNext);
        roverBust.runRover(roverNext);
        assertThat(roverNext.getPosY(), is(2));
    }

    @Test
    public void should_OutPut_Be_1_4_W_When_Input_Rover_2_3_N_Instruction_LMRML() {
        rover = new Rover(2 , 3, 'n');
        rover.setInstruction("LMRML");
        roverBust.addRover(rover);
        roverBust.runRover(rover);
        assertThat(rover.getPosX(),is(1));
        assertThat(rover.getPosY(),is(4));
        assertThat(rover.getOrientation().orientationName(),is('W'));
    }

    @Test
    public void should_OutPut_Be_1_2_N_When_Input_Rover_1_3_N_Instruction_LMLMLMLMM(){
        rover = new Rover(1 , 2, 'n');
        rover.setInstruction("LMLMLMLMM");

        roverBust.addRover(rover);
        roverBust.runRover(rover);
        assertThat(rover.getPosX(),is(1));
        assertThat(rover.getPosY(),is(3));
        assertThat(rover.getOrientation().orientationName(),is('N'));
    }

    @Test
    public void should_OutPut_Be_5_1_E_When_Input_Rover_3_3_E_Instruction_MMRMMRMRRM() {
        rover = new Rover(3 , 3, 'e');
        rover.setInstruction("MMRMMRMRRM");

        roverBust.addRover(rover);
        roverBust.runRover(rover);
        assertThat(rover.getPosX(),is(5));
        assertThat(rover.getPosY(),is(1));
        assertThat(rover.getOrientation().orientationName(),is('E'));
    }
}
