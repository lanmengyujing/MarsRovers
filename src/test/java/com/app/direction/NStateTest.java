package com.app.direction;

import com.app.exception.OutOfBoundException;
import com.app.game.Plateau;
import com.app.game.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/30/13
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class NStateTest {
    Rover rover;
    NState state;
    @Before
    public void setup(){
        rover = new Rover(2 ,3 , 'n');
        state = new NState(rover);
    }

    @Test
    public void should_in_east_when_turn_right(){
        assertThat(state.turnRight(), instanceOf(EState.class));
    }

    @Test
    public void should_in_west_when_turn_left(){
        assertThat(state.turnLeft(),instanceOf(WState.class));
    }

    @Test
    public void should_rover_in_4_when_forward() throws OutOfBoundException {
        Plateau.getInstance().setUpperX(7);
        Plateau.getInstance().setUpperY(7);
        state.forward();
        assertThat(rover.getPosY(), is(4));
    }
}
