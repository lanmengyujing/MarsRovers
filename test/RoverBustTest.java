
import MarsRover.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RoverBustTest {
    private RoverBust roverBust;
    private RoverManager manager;
    private Rover rover;
    @Before
    public void setup(){
        Plateau.getInstance().setUpperX(5);
        Plateau.getInstance().setUpperY(5);
        roverBust = new RoverBust();
        manager = new RoverManager();
        rover = new Rover("Tony");
    }

    @Test (expected = OutOfBoundException.class)
    public void should_Rover_Out_Bound_When_Original_Position_Is_9And7(){
        manager.initPositionAndOrientation(rover,"9 7 N");
        roverBust.addRover(rover);
        assertThat(roverBust.isOutBound(rover),is(true));
    }

    @Test (expected = IllegalArgumentException.class)
    public void should_Rover_Out_Bound_When_Original_Position_Is_Negative4And7(){
        manager.initPositionAndOrientation(rover,"-4 7 N");
        roverBust.addRover(rover);
        assertThat(roverBust.isOutBound(rover),is(true));
    }

    @Test
    public void should_Rovers_Crash_When_Input_Rover_1_1_N_Instruction_M_And_Rover_1_1_S_Instruction_M(){
        manager.initPositionAndOrientation(rover,"1 1 N");
        Rover roverNext = new Rover("David");
        manager.initPositionAndOrientation(roverNext,"1 1 s");
        roverBust.addRover(rover);
        roverBust.addRover(roverNext);
        assertThat(roverBust.checkCrash(roverNext),is(true));
    }

    @Test
    public void should_OutPut_Be_1_4_W_When_Input_Rover_2_3_N_Instruction_LMRML(){
        manager.initPositionAndOrientation(rover,"2 3 n");
        manager.initCommand(rover,"LMRML");
        roverBust.addRover(rover);
        roverBust.runRover(rover);
        assertThat(rover.getPosX(),is(1));
        assertThat(rover.getPosY(),is(4));
        assertThat(rover.getOrientation().orientationName(),is('W'));
    }

    @Test
    public void should_OutPut_Be_1_2_N_When_Input_Rover_1_3_N_Instruction_LMLMLMLMM(){
        manager.initPositionAndOrientation(rover,"1 2 n");
        manager.initCommand(rover,"LMLMLMLMM");
        roverBust.addRover(rover);
        roverBust.runRover(rover);
        assertThat(rover.getPosX(),is(1));
        assertThat(rover.getPosY(),is(3));
        assertThat(rover.getOrientation().orientationName(),is('N'));
    }

    @Test
    public void should_OutPut_Be_5_1_E_When_Input_Rover_3_3_E_Instruction_MMRMMRMRRM(){
        manager.initPositionAndOrientation(rover,"3 3 e");
        manager.initCommand(rover,"MMRMMRMRRM");
        roverBust.addRover(rover);
        roverBust.runRover(rover);
        assertThat(rover.getPosX(),is(5));
        assertThat(rover.getPosY(),is(1));
        assertThat(rover.getOrientation().orientationName(),is('E'));
    }

}
