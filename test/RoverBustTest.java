
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class RoverBustTest {
    RoverBust roverBust;

    @Before
    public void setup(){
        Plateau.getInstance().setUpperX(5);
        Plateau.getInstance().setUpperY(5);
        roverBust = new RoverBust();
    }

    @Test
    public void should_Rover_Out_Bound_When_Original_Position_Is_9And7(){
        Rover rover = new Rover( "Tim",9,7,'N');
        ArrayList<Rover> roverList = new ArrayList<Rover>();
        roverList.add(rover);
        assertThat(roverBust.isOutBound(rover),is(true));
    }

    @Test
    public void should_Rover_Out_Bound_When_Original_Position_Is_Negative4And7(){
        Rover rover = new Rover(-4,7,'N');
        ArrayList<Rover> roverList = new ArrayList<Rover>();
        roverList.add(rover);
        assertThat(roverBust.isOutBound(rover),is(true));
    }

    @Test
    public void should_Rovers_Crash_When_Input_Rover_1_1_N_Instruction_M_And_Rover_1_1_S_Instruction_M(){
        Rover rover = new Rover("Green",1,1,'N');
        if (roverBust.isInstructionValid("M")){
            rover.setInstruction("M");
        }
        Rover roverNext = new Rover("David",1,1,'s');
        if (roverBust.isInstructionValid("M")){
            roverNext.setInstruction("M");
        }
        ArrayList<Rover> roverList = new ArrayList<Rover>();
        roverList.add(rover);
        roverList.add(roverNext);

        roverBust.setRovers(roverList);
        assertThat(roverBust.checkCrash(roverNext),is(true));
    }

    @Test
    public void should_OutPut_Be_1_4_W_When_Input_Rover_2_3_N_Instruction_LMRML(){
        Rover rover = new Rover(2,3,'N');
        rover.setInstruction("LMRmL");
        ArrayList<Rover> roverList = new ArrayList<Rover>();
        roverList.add(rover);
        roverBust.setRovers(roverList);
        roverBust.startMoving();
        roverBust.getRovers();
        assertThat(roverList.get(0).getPosX(),is(1));
        assertThat(roverList.get(0).getPosY(),is(4));
        assertThat(roverList.get(0).getOrientation(),is('W'));
    }

    @Test
    public void should_OutPut_Be_1_2_N_When_Input_Rover_1_3_N_Instruction_LMLMLMLMM(){
        Rover rover = new Rover(1,2,'N');
        roverBust.isInstructionValid("LMLMLMLMM");
        rover.setInstruction("LMLMLMLMM");
        ArrayList<Rover> roverList = new ArrayList<Rover>();
        roverList.add(rover);
        roverBust.setRovers(roverList);
        roverBust.startMoving();
        roverBust.getRovers();
        assertThat(roverList.get(0).getPosX(),is(1));
        assertThat(roverList.get(0).getPosY(),is(3));
        assertThat(roverList.get(0).getOrientation(),is('N'));
    }

    @Test
    public void should_OutPut_Be_5_1_E_When_Input_Rover_3_3_E_Instruction_MMRMMRMRRM(){
        Rover rover = new Rover(3,3,'E');
        roverBust.isInstructionValid("MMRMMRMRRM");
        rover.setInstruction("MMRMMRMRRM");
        ArrayList<Rover> roverList = new ArrayList<Rover>();
        roverList.add(rover);
        roverBust.setRovers(roverList);
        roverBust.startMoving();
        roverBust.getRovers();
        assertThat(roverList.get(0).getPosX(),is(5));
        assertThat(roverList.get(0).getPosY(),is(1));
        assertThat(roverList.get(0).getOrientation(),is('E'));
    }


}
