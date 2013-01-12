import MarsRover.Plateau;
import MarsRover.Rover;
import MarsRover.RoverBust;
import MarsRover.RoverManager;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 下午4:39
 * To change this template use File | Settings | File Templates.
 */
public class RoverManagerTest {
    private RoverManager manager;
    private Rover rover;
    @Before
    public void setup(){
        Plateau.getInstance().setUpperX(5);
        Plateau.getInstance().setUpperY(5);

        manager = new RoverManager();
        rover = new Rover("Tony");
    }

    @Test
    public void should_rover_originalPlace_be_5_1_E_when_input_5_1_E(){
        manager.initPositionAndOrientation(rover, "5 1 e");
        assertThat(rover.getPosX(),is(5));
        assertThat(rover.getPosY(),is(1));
        assertThat(rover.getOrientation().orientationName(),is('E'));
    }

    @Test
    public void should_OutPut_Be_5_1_E_When_Input_Rover_3_3_E_Instruction_MMRMMRMRRM(){
        manager.initPositionAndOrientation(rover, "3 3 E");
        manager.initCommand(rover,"MMRMMRMRRM");
        assertThat(rover.getInstruction(),is("MMRMMRMRRM"));
    }

}
