import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RoverTest {
    Rover rover;

    @Before
    public void setup() {
        rover = new Rover("Iran", 0, 0, 'N');
        Plateau.getInstance().setUpperX(5);
        Plateau.getInstance().setUpperY(5);
    }

    @Test
    public void should_set_attributes_of_a_rover() {
        rover = new Rover("Tom", 5, 6, 's');

        assertThat(rover.getName(), equalTo("Tom"));
        assertThat(rover.getPosX(), is(5));
        assertThat(rover.getPosY(), is(6));
        assertThat(rover.getOrientation(), is('S'));
    }

    @Test
    public void should_Instruction_Be_LMMR_When_SetInstruction_LMMR() {
        rover.setInstruction("LMMR");
        assertThat(rover.getInstruction(), equalTo("LMMR"));
    }

    @Test
    public void should_Orientation_Be_W_When_Command_is_L() {
        rover.operation('L');
        assertThat(rover.getOrientation(), is('W'));
    }

    @Test
    public void should_Orientation_Be_E_When_Command_is_R() {
        rover.operation('R');
        assertThat(rover.getOrientation(), is('E'));
    }

    @Test
    public void should_PosY_Be_1_When_Command_is_M() {
        rover.operation('m');
        assertThat(rover.getPosY(), is(1));
    }


}
