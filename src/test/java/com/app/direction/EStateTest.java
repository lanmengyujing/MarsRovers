package com.app.direction;

import com.app.exception.OutOfBoundException;
import com.app.game.Plateau;
import com.app.game.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/29/13
 * Time: 6:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class EStateTest {
    private EState state;
    private Rover rover;
    @Before
    public void setUp() throws Exception {
        rover = new Rover(5, 2,'n');
        state = new EState(rover);
        Plateau.getInstance().setUpperX(10);
        Plateau.getInstance().setUpperY(10);
    }

    @Test
    public void should_get_north_when_turn_left(){
        assertThat(state.turnLeft() instanceof NState ,is(true));
    }

    @Test
    public void should_get_south_when_turn_right(){

        assertThat((state.turnRight() instanceof SState) ,is(true));
    }

    @Test
    public void should_rover_move_when_forward() throws OutOfBoundException {
        state.forward();
        assertThat(rover.getPosX(), is(6));
    }

}
