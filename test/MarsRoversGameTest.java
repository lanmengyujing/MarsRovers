import MarsRover.MarsRoversGame;
import MarsRover.Plateau;
import MarsRover.Rover;
import MarsRover.RoverBust;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 下午3:30
 * To change this template use File | Settings | File Templates.
 */
public class MarsRoversGameTest {
    private MarsRoversGame marsRoversGame;


    @Before
    public void setup(){
        marsRoversGame = new MarsRoversGame();
        marsRoversGame.initPlateau("9 9");
    }

    @Test
    public void should_rover_place_be_5_1_E_when_input_5_1_E(){
        Rover rover = new Rover("Tony");
        marsRoversGame.placeRover(rover, "5 1 E");
        assertThat(rover.getPosX(),is(5));
        assertThat(rover.getPosY(),is(1));
        assertThat(rover.getOrientation().orientationName(),is('E'));
    }

    @Test
    public void should(){
        String strTest = "5 5\n"
                + "1 1 N\n"
                + "ML\n"
                + "2 2 N\n"
                + "MRrl\n";
        marsRoversGame = new MarsRoversGame(strTest);
        marsRoversGame.startGame();
    }
}
