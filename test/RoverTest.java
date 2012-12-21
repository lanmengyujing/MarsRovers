import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RoverTest {
    Rover rover;

    @Before
    public void setup() {
        rover = new Rover("Iran",0,0,'N');
    }

    @Test
    public void should_Name_Be_Tom_When_SetName_Tom(){
        rover.setName("Tom");
        assertThat(rover.getName(),equalTo("Tom"));
    }

    @Test
    public void should_PosX_Be_5_When_SetPosX_5(){
        rover.setPosX(5);
        assertThat(rover.getPosX(),is(5));
    }

    @Test
    public void should_PosY_Be_5_When_SetPosY_5(){
        rover.setPosY(5);
        assertThat(rover.getPosY(),is(5));
    }

    @Test
    public void should_Orientation_Be_S_When_SetOrientation_S(){
        rover.setOrientation('s');
        assertThat(rover.getOrientation(),is('S'));
    }

    @Test
    public void should_Instruction_Be_LMMR_When_SetInstruction_LMMR(){
        rover.setInstruction("LMMR");
        assertThat(rover.getInstruction(),equalTo("LMMR"));
    }

    @Test
    public void should_PosY_Be_1_When_MoveForward(){
        rover.moveForward();
        assertThat(rover.getPosY(),is(1));
    }

    @Test
    public void should_Orientation_Be_W_When_TurnLeft(){
        rover.turnLeft();
        assertThat(rover.getOrientation(),is('W'));
    }

    @Test
    public void should_Orientation_Be_E_When_TurnLeft(){
        rover.turnRight();
        assertThat(rover.getOrientation(),is('E'));
    }

    @Test
    public void should_Orientation_Be_W_When_Command_is_L(){
        rover.operation('L');
        assertThat(rover.getOrientation(),is('W'));
    }

    @Test
    public void should_Orientation_Be_E_When_Command_is_R(){
        rover.operation('R');
        assertThat(rover.getOrientation(),is('E'));
    }

    @Test
    public void should_PosY_Be_1_When_Command_is_M(){
        rover.operation('m');
        assertThat(rover.getPosY(),is(1));
    }


}
