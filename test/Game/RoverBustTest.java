package Game;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RoverBustTest {
    private RoverBust roverBust;
    private Client client;
    private Rover rover;
    @Before
    public void setup(){
        client = new Client();
        client.setPlateau("5 5");
        roverBust = new RoverBust();
        rover = new Rover();
    }

    @Test (expected = OutOfBoundException.class)
    public void should_Rover_Out_Bound_When_Original_Position_Is_9And7(){
        client.setRoverPlace("9 7 N", rover);
        roverBust.addRover(rover);
    }

    @Test (expected = IllegalArgumentException.class)
    public void should_Rover_Out_Bound_When_Original_Position_Is_Negative4And7(){
        client.setRoverInstruction("-4 7 t", rover);
        roverBust.addRover(rover);
    }


    @Test  (expected = RuntimeException.class)
    public void should_Rovers_Crash_When_Input_Rover_1_1_N_Instruction_M_And_Rover_1_3_S_Instruction_M(){
        client.setRoverPlace("1 1 n", rover);
        client.setRoverInstruction("m", rover);
        roverBust.addRover(rover);
        roverBust.runRover(rover);

        Rover roverNext = new Rover();
        client.setRoverPlace("1 3 s", roverNext);
        client.setRoverInstruction("m", roverNext);
        roverBust.addRover(roverNext);
        roverBust.runRover(roverNext);
    }

    @Test
    public void should_OutPut_Be_1_4_W_When_Input_Rover_2_3_N_Instruction_LMRML(){
        client.setRoverPlace("2 3 n", rover);
        client.setRoverInstruction("LMRML", rover);
        roverBust.addRover(rover);
        roverBust.runRover(rover);
        assertThat(rover.getPosX(),is(1));
        assertThat(rover.getPosY(),is(4));
        assertThat(rover.getOrientation().orientationName(),is('W'));
    }

    @Test
    public void should_OutPut_Be_1_2_N_When_Input_Rover_1_3_N_Instruction_LMLMLMLMM(){
        client.setRoverPlace("1 2 n", rover);
        client.setRoverInstruction("LMLMLMLMM", rover);
        roverBust.addRover(rover);
        roverBust.runRover(rover);
        assertThat(rover.getPosX(),is(1));
        assertThat(rover.getPosY(),is(3));
        assertThat(rover.getOrientation().orientationName(),is('N'));
    }

    @Test
    public void should_OutPut_Be_5_1_E_When_Input_Rover_3_3_E_Instruction_MMRMMRMRRM(){
        client.setRoverPlace("3 3 e", rover);
        client.setRoverInstruction("MMRMMRMRRM", rover);
        roverBust.addRover(rover);
        roverBust.runRover(rover);
        assertThat(rover.getPosX(),is(5));
        assertThat(rover.getPosY(),is(1));
        assertThat(rover.getOrientation().orientationName(),is('E'));
    }

}
