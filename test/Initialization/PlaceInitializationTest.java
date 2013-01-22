package Initialization;

import Game.Rover;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-20
 * Time: 上午10:34
 * To change this template use File | Settings | File Templates.
 */
public class PlaceInitializationTest {
    @Test
    public void should_rover_in_23N_when_input_23N() {
        Rover rover = new Rover();
        PlaceInitialization initialization = new PlaceInitialization("2 3 N", rover);
        initialization.configure();
        assertThat(rover.getPosX(), is(2));
        assertThat(rover.getPosY(), is(3));
        assertThat(rover.getOrientation().orientationName(), is('N'));
    }
}
